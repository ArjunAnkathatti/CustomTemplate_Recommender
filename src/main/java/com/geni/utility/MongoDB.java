package com.geni.utility;


import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MongoDB {
	private static MongoClient mongoClient = null;
	
	public static DB getMongoConnection (String dbName) {
		mongoClient = new MongoClient("localhost", 27017);
		@SuppressWarnings("deprecation")
		DB db = mongoClient.getDB(dbName);
		return db;
	}
	
	public static void closeMongoConnection() {
		if (mongoClient != null) {
			mongoClient.close();
			mongoClient = null;
		}
	}
}