package com.insure.server;

import java.util.concurrent.atomic.AtomicInteger;

public class Claim {
    private AtomicInteger uuid; // id da claim
    private String description;
    private final int userID; //

    public Claim (int id, String description, int userID){
        this.uuid = new AtomicInteger(id);
        this.description = description;
        this.userID = userID;
    }

    public int getUuid() {
        return uuid.get();
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
        return "Claim ID:" + uuid + "\n" +
                "Description:" + this.description;
    }
}
