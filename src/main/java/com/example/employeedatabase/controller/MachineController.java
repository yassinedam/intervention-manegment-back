package com.example.employeedatabase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeedatabase.entity.MachineEntity;
import com.example.employeedatabase.model.Machine;
import com.example.employeedatabase.service.MachineService;

@RestController
@CrossOrigin(origins = "*")
public class MachineController {
	@Autowired
	MachineService machineService;
	@RequestMapping(value = "getallmachines", method = RequestMethod.GET)
	public List<Machine> getAllMachines(){
		return machineService.getAllMachines();
	}
	@RequestMapping(value = "getmachinebycode/{code}", method = RequestMethod.GET)
	public Machine getMachinesbyid(@PathVariable String code){
		return machineService.getMachinebyCode(code);
	}
	@RequestMapping(value = "getallmachinesinIntervention/{id}", method = RequestMethod.GET)
	public List<Machine> getallMachinesInIntervention(@PathVariable("id") int id){
		return machineService.getallMachinesInIntervention(id);
	}
	
	@RequestMapping(value = "addmachine", method = RequestMethod.POST)
	public String addMachine(@RequestBody MachineEntity machine) {
		return machineService.addMachine(machine);
	}
	
	@RequestMapping(value = "updatemachine", method = RequestMethod.PUT)
	public String updateMachine(@RequestBody MachineEntity machine) {
		return machineService.updateMachine(machine);
	}
	
	@RequestMapping(value = "deletemachine", method = RequestMethod.DELETE)
	public String removeMachine(@RequestBody MachineEntity machine) {
		return machineService.removeMachine(machine);
	}
	

}
