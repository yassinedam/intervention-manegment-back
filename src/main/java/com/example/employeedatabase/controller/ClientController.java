package com.example.employeedatabase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeedatabase.entity.ClientEntity;
import com.example.employeedatabase.model.Client;
import com.example.employeedatabase.service.ClientService;

;
@RestController
@CrossOrigin(origins = "*")
public class ClientController {

	@Autowired
	ClientService clientservice;
	
	@RequestMapping(value = "getallclients", method = RequestMethod.GET)
	public List<Client> getAllClients(){
		return clientservice.getAllClients();
	}
	@RequestMapping(value = "getclient/{id}", method = RequestMethod.GET)
	public Client getClient(@PathVariable int id){
		return clientservice.getById(id);
	}
	@RequestMapping(value = "getClientByInterventionId/{id}", method = RequestMethod.GET)
	public Client getClientByInterventionId(@PathVariable int id){
		return clientservice.getClientByInterventionId(id);
	}
	@RequestMapping(value = "getallclientsincompany/{mf}", method = RequestMethod.GET)
	public List<Client> getallClientsInCompany(@PathVariable("mf") String mf){
		return clientservice.getallClientsInCompany(mf);
	}
	
	
	@RequestMapping(value = "addclient", method = RequestMethod.POST)
	public String addEmployee(@RequestBody ClientEntity Client) {
		return clientservice.addClient(Client);
	}
	
	@RequestMapping(value = "updateclient", method = RequestMethod.PUT)
	public String updateEmployee(@RequestBody ClientEntity Client) {
		return clientservice.updateClient(Client);
	}
	
	@RequestMapping(value = "deleteclient", method = RequestMethod.DELETE)
	public String removeEmployee(@RequestBody ClientEntity Client) {
		return clientservice.removeClient(Client);
	}
}
