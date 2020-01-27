package com.insure.server;

        import com.sun.org.apache.bcel.internal.generic.NEW;

        import javax.jws.WebService;
        import java.util.Map;
        import java.util.UUID;
        import java.util.concurrent.ConcurrentHashMap;
        import java.util.concurrent.atomic.AtomicInteger;

@WebService
public class ClaimDataStore {
    // field to keep a Unique ID
    private AtomicInteger ID = new AtomicInteger(0);
    private String Description;
    private int userID;
    // field with a Collection to store the data
    protected Map<Integer, String> DataStore  = new ConcurrentHashMap<Integer, String>();

    // Constructor also create initial data
    public ClaimDataStore(){
        //this.DataStore = new ConcurrentHashMap<Integer, String>();
        //this.ID = new AtomicInteger(0);
        // preload data (create a few claims)
    }

    // define and implement the API:
    // Create Claim: Da parte do cliente, ele apenas conseguirá utilizar este metodo para criar uma claim com descrição.
    // O ID é criado automaticamente do lado do Server
    public int createClaim(String Description, int userID){
        Claim claim = new Claim(ID.incrementAndGet(), Description, userID);
        return ID.get();
        // criar metodo de verificação ID do cliente/funcionário
    }

    // create/retrieve/update claims on the data store safely, ex:
    // int createClaim() { //return a unique claim id }
    // list/create/read/update/delete documents of claims on the datastore safely.


    static class MyThread extends Thread {

        //private ClaimDataStore DB;
        ClaimDataStore DB = new ClaimDataStore();
        private String Description;
        private int userID;

        // update the constructor to use a counter
        MyThread(String Description, int userID) {
            this.Description = Description;
            this.userID = userID;
        }

        @Override
        public void run() {
            // update the loop
            for (int i = 0; i < 6; i++) {
                // writeHello();
                int claim = DB.createClaim(Description, userID);
                System.out.println(Description + " " + claim);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        // fix the calls to the updated constructor
        Thread a = new MyThread("a",1);
        Thread b = new MyThread("B", 2);
        a.start();
        b.start();
        a.join();
        b.join();
        // output the final counter value
    }
}
