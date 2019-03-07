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
	private Service service;
	
	@RequestMapping(method = RequestMethod.POST, value = "/addAircrafts")
	public void addAircraft(@RequestBody Aircraft aircraft) {
		service.addAircraft(aircraft);
	}
	
	@RequestMapping("/getAircrafts")
	public ArrayList<Aircraft> getAircrafts() {
		return new ArrayList<Aircraft>();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/aircrafts/{programName}")
	public void addAircraftInDB(@RequestBody Aircraft aircraft, @PathVariable String programName) {
		service.addAircraftInDB(aircraft, programName);
	}
}
