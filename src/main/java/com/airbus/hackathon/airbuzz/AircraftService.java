package com.airbus.hackathon.airbuzz;

import java.awt.List;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Set;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

@org.springframework.stereotype.Service
public class AircraftService {
	
	private MongoClient mongoClient;
	private ArrayList<Aircraft> aircrafts;
	private DB aircraftsDatabase;
	public AircraftService() throws UnknownHostException {
		mongoClient = new MongoClient();
		aircrafts = new ArrayList<Aircraft>();
		aircraftsDatabase = mongoClient.getDB("Aircrafts");
	}
	
	public ArrayList<Aircraft> getAircrafts(String programName) {
		DBCollection collection = aircraftsDatabase.getCollection(programName);
		DBCursor dbCursor = collection.find();
		ArrayList<Aircraft> list = new ArrayList<Aircraft>();
		while(dbCursor.hasNext()) {
			Aircraft aircraft = getAircraftsFromDBObject(dbCursor.next());
			list.add(aircraft);
		}
		return list;
	}
	
	
	public void addAircraftInDB(Aircraft aircraft, String programName) {
		DBCollection collection = aircraftsDatabase.getCollection(programName);
		DBObject aircraftDBObject = createDBObject(aircraft); 
		WriteResult result = collection.insert(aircraftDBObject);
		System.out.println(result);
		
	}
	
	private Aircraft getAircraftsFromDBObject(DBObject dbObject) {
		Aircraft aircraft = new Aircraft();
		aircraft.setMsn((String)dbObject.get("msn"));
		aircraft.setHarnessLength((Double)dbObject.get("harnessLength"));
		aircraft.setGrossWeight((Double)dbObject.get("grossWeight"));
		aircraft.setAtmosphericPressure((Double)dbObject.get("atmosphericPressure"));
		aircraft.setRoomTemperature((Double)dbObject.get("roomTemperature"));
		aircraft.setLeftWingFuelCapacity((Integer)dbObject.get("leftWingFuelCapacity"));
		aircraft.setRightWingFuelCapacity((Integer)dbObject.get("rightWingFuelCapacity"));
		aircraft.setLeftWingFuelQuantity((Integer)dbObject.get("leftWingFuelQuantity"));
		aircraft.setRightWingFuelQuantity((Integer)dbObject.get("leftWingFuelQuantity"));
		aircraft.setMaxAltitudeToBeReached((Integer)dbObject.get("maxAltitudeToBeReached"));
		aircraft.setFlightNumber((String)dbObject.get("flightNumber"));
		aircraft.setAirport((String)dbObject.get("airport"));
		
		return aircraft;
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
	
}
