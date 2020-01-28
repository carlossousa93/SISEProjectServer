package com.insure.server;

public class Main {
    static class MyThread extends Thread {

        //private ClaimDataStore DB;
        private ClaimDataStore DS;
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
                int claim = DS.createClaim(Description, userID);
                System.out.println(Description + " " + claim);
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {
        //System.out.println("Project template - server");

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
