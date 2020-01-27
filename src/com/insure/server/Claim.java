package com.insure.server;

public class Claim {
    private int uuid;
    private String description;
    public Claim (int uuid, String description){
        this.uuid = uuid;
        this.description = description;
    }
    public void setUuid(int uuid) {
        this.uuid = uuid;
    }
    public int getUuid() {
        return uuid;
    }
    public String getDescription() {
        return description;
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
