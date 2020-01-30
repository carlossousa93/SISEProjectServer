package com.insure.server;

import javax.xml.ws.Endpoint;

public class Main {
    //Server
    public static void main(String args[]) {
        System.out.println("\"Claim Data Store Web Service is starting.\"");
        ClaimDataStore ClaimDataStore = new ClaimDataStore();
        Endpoint.publish("http://localhost:8090/docstorage", ClaimDataStore);
    }
}
