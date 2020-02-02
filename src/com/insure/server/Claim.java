package com.insure.server;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Claim {
    private AtomicInteger claimID = new AtomicInteger(0);
    private AtomicInteger docID = new AtomicInteger(0);

    private String description;
    public String UserID;
    public Map<Integer, Document> documents = new ConcurrentHashMap<Integer, Document>();

    // Constructor of the claim
    public Claim(AtomicInteger ClaimID, String description, String UserID) {
        this.claimID = claimID;
        this.description = description;
        this.UserID = UserID;
    }

    //Writes description of claim
    public void setClaimDescription(String description) {
        this.description = description;
    }

    public int getClaimID(){
        return this.claimID.get();
    }

    public String getUserID(){
        return this.UserID;
    }

    public void addDocument(Document document){
        int docID = document.getdocID();

        this.docID = i;
        documents.put(i, document);
    }

    public void increment() {
        this.claimID.incrementAndGet();
    }

    @Override
    public String toString(){
        return "Claim ID: " + claimID  + " Description:" + this.description;
    }
}
