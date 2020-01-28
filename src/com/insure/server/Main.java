package com.insure.server;

public class Main {

    static class MyThread extends Thread {

        ClaimDataStore DS;
        //ClaimDataStore DS = new ClaimDataStore();
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
                int claim = DS.createClaim(Description, userID);
                System.out.println(Description + " " + claim);
            }
        }
    }
    public static void main(String args[]) {
        //System.out.println("Project template - server");
    }
}
