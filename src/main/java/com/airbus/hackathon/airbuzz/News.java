package com.airbus.hackathon.airbuzz;

public class News {

	private String headline;
	private String details;
	
	public News(String headline, String details) {
		super();
		this.headline = headline;
		this.details = details;
	}
	
	public News() {
		super();
	}
	
	public String getHeadline() {
		return headline;
	}
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	
}
