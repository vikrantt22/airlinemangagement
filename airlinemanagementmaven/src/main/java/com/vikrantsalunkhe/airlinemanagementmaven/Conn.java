/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.vikrantsalunkhe.airlinemanagementmaven;

/**
 *
 * @author User
 */
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Conn {
    
    MongoClient mongoClient;
    MongoDatabase database;
    MongoCollection<Document> collection;
    
    public Conn() {
        try {
            // Connect to MongoDB server (localhost on default port 27017)
            mongoClient = new MongoClient("localhost", 27017);

            // Connect to your database
            database = mongoClient.getDatabase("mydatabase");

            // Get the collection, replace "yourCollectionName" with your actual collection name
            collection = database.getCollection("employee");

            System.out.println("Connected to MongoDB!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Example method to insert a document
    public void insertDocument(Document document) {
        try {
            collection.insertOne(document);
            System.out.println("Document inserted!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Example method to find documents
    public void findDocuments() {
        try {
            for (Document doc : collection.find()) {
                System.out.println(doc.toJson());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Close the connection when done
    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("MongoDB connection closed.");
        }
    }
}

