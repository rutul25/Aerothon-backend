package com.airbus.hackathon.airbuzz;

import java.util.ArrayList;

import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BootController {
	
	@Autowired
	private AircraftService service;
	
	@Autowired
	private NewsService newsservice;
	
	
	@RequestMapping("/aircrafts/{programName}")
	public ArrayList<Aircraft> getAircrafts(@PathVariable String programName) {
		return service.getAircrafts(programName);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/aircrafts/{programName}")
	public void addAircraftInDB(@RequestBody Aircraft aircraft, @PathVariable String programName) {
		service.addAircraftInDB(aircraft, programName);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/news")
	public void addNewsInDB(@RequestBody News news) {
		newsservice.addNewsInDB(news);
	}
	
	@RequestMapping("/news")
	public ArrayList<News> getAllNews() {
		return newsservice.getAllNewsFromDB();
	}
}
