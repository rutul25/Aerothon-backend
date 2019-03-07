package com.airbus.hackathon.airbuzz;

public class Aircraft {

	private String msn;
	private double harnessLength;
	private double grossWeight;
	private double atmosphericPressure;
	private double roomTemperature;
	private String airport;
	private int leftWingFuelCapacity;
	private int rightWingFuelCapacity;
	private int leftWingFuelQuantity;
	private int rightWingFuelQuantity;
	private int maxAltitudeToBeReached;
	private String flightNumber;
	
	
	public Aircraft() {
		super();
	}

	public Aircraft(String msn, double harnessLength, double grossWeight, double atmosphericPressure,
			double roomTemperature, String airport, int leftWingFuelCapacity, int rightWingFuelCapacity,
			int leftWingFuelQuantity, int rightWingFuelQuantity, int maxAltitudeToBeReached, String flightNumber) {
		super();
		this.msn = msn;
		this.harnessLength = harnessLength;
		this.grossWeight = grossWeight;
		this.atmosphericPressure = atmosphericPressure;
		this.roomTemperature = roomTemperature;
		this.airport = airport;
		this.leftWingFuelCapacity = leftWingFuelCapacity;
		this.rightWingFuelCapacity = rightWingFuelCapacity;
		this.leftWingFuelQuantity = leftWingFuelQuantity;
		this.rightWingFuelQuantity = rightWingFuelQuantity;
		this.maxAltitudeToBeReached = maxAltitudeToBeReached;
		this.flightNumber = flightNumber;
	}
	
	public String getMsn() {
		return msn;
	}
	public void setMsn(String msn) {
		this.msn = msn;
	}
	public double getHarnessLength() {
		return harnessLength;
	}
	public void setHarnessLength(double harnessLength) {
		this.harnessLength = harnessLength;
	}
	public double getGrossWeight() {
		return grossWeight;
	}
	public void setGrossWeight(double grossWeight) {
		this.grossWeight = grossWeight;
	}
	public double getAtmosphericPressure() {
		return atmosphericPressure;
	}
	public void setAtmosphericPressure(double atmosphericPressure) {
		this.atmosphericPressure = atmosphericPressure;
	}
	public double getRoomTemperature() {
		return roomTemperature;
	}
	public void setRoomTemperature(double roomTemperature) {
		this.roomTemperature = roomTemperature;
	}
	public String getAirport() {
		return airport;
	}
	public void setAirport(String airport) {
		this.airport = airport;
	}
	public int getLeftWingFuelCapacity() {
		return leftWingFuelCapacity;
	}
	public void setLeftWingFuelCapacity(int leftWingFuelCapacity) {
		this.leftWingFuelCapacity = leftWingFuelCapacity;
	}
	public int getRightWingFuelCapacity() {
		return rightWingFuelCapacity;
	}
	public void setRightWingFuelCapacity(int rightWingFuelCapacity) {
		this.rightWingFuelCapacity = rightWingFuelCapacity;
	}
	public int getLeftWingFuelQuantity() {
		return leftWingFuelQuantity;
	}
	public void setLeftWingFuelQuantity(int leftWingFuelQuantity) {
		this.leftWingFuelQuantity = leftWingFuelQuantity;
	}
	public int getRightWingFuelQuantity() {
		return rightWingFuelQuantity;
	}
	public void setRightWingFuelQuantity(int rightWingFuelQuantity) {
		this.rightWingFuelQuantity = rightWingFuelQuantity;
	}
	public int getMaxAltitudeToBeReached() {
		return maxAltitudeToBeReached;
	}
	public void setMaxAltitudeToBeReached(int maxAltitudeToBeReached) {
		this.maxAltitudeToBeReached = maxAltitudeToBeReached;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
}
