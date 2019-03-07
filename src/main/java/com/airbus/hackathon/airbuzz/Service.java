package com.airbus.hackathon.airbuzz;

import java.awt.List;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Set;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

@org.springframework.stereotype.Service
public class Service {
	
	private MongoClient mongoClient;
	private ArrayList<Aircraft> aircrafts;
	private DB aircraftsDatabase;
	public Service() throws UnknownHostException {
		mongoClient = new MongoClient();
		aircrafts = new ArrayList<Aircraft>();
		aircraftsDatabase = mongoClient.getDB("Aircrafts");
	}

	public void printCollections() {
		Set<String> names = aircraftsDatabase.getCollectionNames();
		for(String name : names) {
			System.out.print(name);
		}
	}
	
	public void addAircraftInDB(Aircraft aircraft, String programName) {
		DBCollection collection = aircraftsDatabase.getCollection(programName);
		DBObject aircraftDBObject = createDBObject(aircraft); 
		WriteResult result = collection.insert(aircraftDBObject);
		System.out.println(result);
		
	}
	
	private static DBObject createDBObject(Aircraft aircraft) {
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
				
		docBuilder.append("msn", aircraft.getMsn());
		docBuilder.append("harnessLength", aircraft.getHarnessLength());
		docBuilder.append("grossWeight", aircraft.getGrossWeight());
		docBuilder.append("atmosphericPressure", aircraft.getAtmosphericPressure());
		docBuilder.append("roomTemperature", aircraft.getRoomTemperature());
		docBuilder.append("airport", aircraft.getAirport());
		docBuilder.append("leftWingFuelCapacity", aircraft.getLeftWingFuelCapacity());
		docBuilder.append("rightWingFuelCapacity", aircraft.getRightWingFuelCapacity());
		docBuilder.append("leftWingFuelQuantity", aircraft.getLeftWingFuelQuantity());
		docBuilder.append("rightWingFuelQuantity", aircraft.getRightWingFuelQuantity());
		docBuilder.append("maxAltitudeToBeReached", aircraft.getMaxAltitudeToBeReached());
		docBuilder.append("flightNumber", aircraft.getFlightNumber());
		
		return docBuilder.get();
	}
	
	public void addAircraft(Aircraft aircraft) {
		System.out.println(aircraft.getMsn());
		System.out.println(aircraft.getFlightNumber());
		System.out.println(aircraft.getAirport());
		System.out.println("**************");
		aircrafts.add(aircraft);
	}
	
	public void printAircrafts() {
		for(Aircraft aircraft : aircrafts) {
			System.out.println(aircraft.getMsn());
			System.out.println(aircraft.getFlightNumber());
			System.out.println(aircraft.getAirport());
			System.out.println("**************");
		}
	}
}
