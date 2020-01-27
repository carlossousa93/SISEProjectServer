package com.insure.server;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ClaimDataStore {
    // field to keep a Unique ID
    private final AtomicInteger ID = new AtomicInteger(0);
    private String Description;
    // field with a Collection to store the data
    private Map<Integer, String> DataStore;

    // Constructor also create initial data

    public ClaimDataStore(){
    // preload data (create a few claims)
    }

    // define and implement the API:
    // create/retrieve/update claims on the data store safely, ex:
    // int createClaim() { //return a unique claim id }
    // list/create/read/update/delete documents of claims on the datastore safely.

}
