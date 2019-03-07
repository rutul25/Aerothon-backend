package com.airbus.hackathon.airbuzz;

import java.awt.List;
import java.net.UnknownHostException;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoTimeoutException;
import com.mongodb.WriteResult;

@Service
public class NewsService {

	private String NEWS_HEADER = "News";
	private MongoClient mongoClient;
	private ArrayList<News> newsList;
	private DB aircraftsDatabase;
	private DBCollection newsCollection;
	public NewsService() throws UnknownHostException {
		mongoClient = new MongoClient();
		newsList = new ArrayList<News>();
		aircraftsDatabase = mongoClient.getDB("Aircrafts");
		newsCollection = aircraftsDatabase.getCollection(NEWS_HEADER);
	}
	
	public void addNewsInDB(News news) {
		DBObject newsDBObject = getDBObjectforNews(news);
		WriteResult result = newsCollection.insert(newsDBObject);
		System.out.println(result);
	}
	
	public DBObject getDBObjectforNews(News news) {
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
		
		docBuilder.append("headline", news.getHeadline());
		docBuilder.append("details", news.getDetails());
		
		return docBuilder.get();
	}
	public ArrayList<News> getAllNewsFromDB() {
		DBCursor dbCursor = newsCollection.find();
		ArrayList<News> newsList = new ArrayList<News>();
		
		while(dbCursor.hasNext()) {
			DBObject dbObject = dbCursor.next();
			News news = getNewsFromDBObject(dbObject);
			newsList.add(news);
		}
		
		return newsList;
		
	}
	
	private News getNewsFromDBObject(DBObject dbObject) {
		News news = new News();
		news.setDetails((String)dbObject.get("details"));
		news.setHeadline((String)dbObject.get("headline"));
		return news;
	}
	
	private DBObject getDBObjectForNews(News news) {
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
		
		docBuilder.append("headline", news.getHeadline());
		docBuilder.append("details", news.getDetails());
		
		return docBuilder.get();
	}
}
