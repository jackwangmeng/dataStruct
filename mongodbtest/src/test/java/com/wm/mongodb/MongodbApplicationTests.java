package com.wm.mongodb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class MongodbApplicationTests {

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("mydb");
        MongoCollection<Document> collection = database.getCollection("test");

        Document doc = new Document("name", "沉默王二")
                .append("age", "18")
                .append("hobbies", Arrays.asList("写作", "敲代码"));
        collection.insertOne(doc);

        System.out.println("集合大小：" +collection.countDocuments());

        Document myDoc = collection.find().first();
        System.out.println("文档内容：" + myDoc.toJson());
    }


}
