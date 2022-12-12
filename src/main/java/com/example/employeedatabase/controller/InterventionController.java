package com.example.employeedatabase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeedatabase.entity.InterventionEntity;
import com.example.employeedatabase.model.Client;
import com.example.employeedatabase.model.Intervention;
import com.example.employeedatabase.service.InterventionService;

@RestController
@CrossOrigin(origins = "*")
public class InterventionController {
	@Autowired
	InterventionService interventionService;
	
	@RequestMapping(value = "getallinterventions", method = RequestMethod.GET)
	public List<Intervention> getAllInterventions(){
		return interventionService.getAllInterventions();
	}
	@RequestMapping(value = "getallinterventionsforintervention/{id}", method = RequestMethod.GET)
	public List<Intervention> getAllInterventionsForIntervenant(@PathVariable int id){
		return interventionService.getAllInterventionsForIntervenant(id);
	}
	
	@RequestMapping(value = "addintervention", method = RequestMethod.POST)
	public String addIntervention(@RequestBody InterventionEntity Intervention) {
		return interventionService.addIntervention(Intervention);
	}
	
	@RequestMapping(value = "updateintervention", method = RequestMethod.PUT)
	public String updateIntervention(@RequestBody InterventionEntity Intervention) {
		return interventionService.updateIntervention(Intervention);
	}
	
	@RequestMapping(value = "deleteintervention", method = RequestMethod.DELETE)
	public String removeIntervention(@RequestBody InterventionEntity Intervention) {
		return interventionService.removeIntervention(Intervention);
	}
	@RequestMapping(value = "getallinterventionsbyClient", method = RequestMethod.GET)
	public List<Intervention> getAllInterventionsbyClient(Client client){
		return interventionService.getAllInterventionsByClient(client);
	}
	
}
