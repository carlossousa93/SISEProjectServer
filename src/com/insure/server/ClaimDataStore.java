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
    public AtomicInteger ID = new AtomicInteger(0);
    public String Description;
    public int userID;
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
        Claim claim = new Claim(ID.get(), Description, userID);
        int claim_ID = claim.getUuid();
        ID.incrementAndGet();
        return claim_ID;
        // criar metodo de verificação ID do cliente/funcionário
    }

    // create/retrieve/update claims on the data store safely, ex:
    // int createClaim() { //return a unique claim id }
    // list/create/read/update/delete documents of claims on the datastore safely.

}
