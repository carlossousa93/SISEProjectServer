package com.insure.server;

import java.util.concurrent.atomic.AtomicInteger;

public class Claim {
    private final int id; // id da claim
    private String description;
    private final int userID; //

    public Claim (int id, String description, int userID){
        this.id = id;
        this.description = description;
        this.userID = userID;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getUserID() {
        return userID;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        return "Claim ID: " + id  + " Description:" + this.description;
    }
}
