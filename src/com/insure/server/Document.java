package com.insure.server;

import java.util.concurrent.atomic.AtomicInteger;

public class Document {
    private String contents;
    private AtomicInteger docID = new AtomicInteger(0);
    private String timestamp;

    public Document (AtomicInteger docID, String contents){
        this.docID = docID;
        this.contents = contents;
        this.timestamp = timestamp;
    }

    public String getContents() {
        return contents;
    }

    public void setTimeStamp(String timestamp){
        this.timestamp = timestamp;
    }

    public String getTimestamp(){
        return timestamp;
    }

    public int getdocID(){
        return this.docID.get();
    }

    public void increment() {
        this.docID.incrementAndGet();
    }

}
