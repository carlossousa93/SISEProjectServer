package com.insure.server;

import javax.jws.WebService;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@WebService
public class ClaimDataStore {
    public Map<Integer, Claim> Datastore = new ConcurrentHashMap<Integer, Claim>(); //claimID, Claim
    public Set<String> UsersStore = new HashSet<String>();

    public AtomicInteger ClaimID = new AtomicInteger(1);
    public String description;
    public String UserID;

    //Constructor
    public ClaimDataStore() {
    }

    //Method adds Claim to the datastore
    public int addClaim(String description, String UserID) {
        if (!UsersIDVerify(UserID)) {
            System.out.println("You are not our client");
        } else {
            Claim claim = createClaim(description, UserID);
            Datastore.put(claim.getClaimID(), claim);
            return claim.getClaimID();
        }
        return 0;
    }

    // Method create new claim
    public Claim createClaim(String description, String UserID){
        Claim claim = new Claim(ClaimID, description, UserID);
        return claim;
    }

    //checks if a claim is in the DataStore
    public boolean isClaimByID(int claimID) {
        return Datastore.containsKey(claimID);
    }

    // Verify client is insured
    public boolean UsersIDVerify(String UserID){
        return UsersStore.contains(UserID);
    }

    //Verifies if client owns target claim
    public boolean clientToClaim(String UserID, int claimID){
        return Datastore.get(claimID).getUserID().equals(UserID);
    }

    //Associates & creates document to a claim, checks if the claim exists, if the person signing is employee/client, receives the content of the document
    public void associateDocument(int claimID, String UserID,String content) {
        if ((UsersIDVerify(UserID) && isClaimByID(claimID) && clientToClaim(UserID, claimID))) {
            String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // Find how to return current timestamp
            Document document = new Document(content, timestamp);
            Datastore.get(claimID).addDocument(document);
        }
        else{
            System.out.println("You can't add Documents to this claim/ Claim doesn't exit");
        }
    }

    //Checks if claim exists and prints out contents for each document associated with it
    public void listDocument(int claimID) {
        if (!isClaimByID(claimID)) {
            System.out.println("This claim doesn't exist");
        } else {
            Datastore.get(claimID).documents.forEach((K,V) -> System.out.println("DocID:" + K + "\n Content:" + V.getContents() + "\n ----------------- \n\n" ));
        }
    }

    // create/retrieve/update claims on the data store safely, ex:
    // int createClaim() { //return a unique claim id }
    // list/create/read/update/delete documents of claims on the datastore safely.
}
