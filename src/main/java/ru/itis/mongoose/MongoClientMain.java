package ru.itis.mongoose;

import com.mongodb.Block;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import org.bson.Document;

import java.util.Arrays;

import static com.mongodb.client.model.Projections.*;

public class MongoClient {
    public static void main(String[] args) {
        //mongoclient

        com.mongodb.client.MongoClient client = MongoClients.create("mongodb+srv://Sergey:7llnjQeDHedaXR41@kinonew.ag4d1.mongodb.net");
        MongoDatabase mongoDatabase = client.getDatabase("user_codep");
        MongoCollection<Document> collections = mongoDatabase.getCollection("user_codep");

//        collections.find().forEach(document -> System.out.println(document.getString("age")));

        Document searchQuery = new Document();

        searchQuery
                .append("age", 26)
                .append("$or", Arrays.asList(
                        new Document("role", "USER"),
                        new Document("nickname", "Sergey")));

//        FindIterable<Document> resultDocuments = collections.find(searchQuery);

//        FindIterable<Document> resultDocuments = collections.find(searchQuery)
//                .projection(new Document("age", 1)
//                        .append("_id", 0)
//                        .append("sandbox", 1)
//                );

        FindIterable<Document> resultDocuments = collections.find(searchQuery)
                .projection(fields(include("age", "_id"), excludeId()));



        for(Document document: resultDocuments) {
            System.out.println(document.toJson());
        }
    }
}
