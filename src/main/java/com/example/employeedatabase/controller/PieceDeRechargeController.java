package com.example.employeedatabase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeedatabase.entity.PieceDeReChargeEntity;
import com.example.employeedatabase.model.PieceDeRecharge;
import com.example.employeedatabase.service.PieceDeRechargeService;



@RestController
@CrossOrigin(origins = "*")
public class PieceDeRechargeController {
	@Autowired
	PieceDeRechargeService PieceService;
	@RequestMapping(value = "getallpieces", method = RequestMethod.GET)
	public List<PieceDeRecharge> getAllMachines(){
		return PieceService.getAllPieces();
	}
	@RequestMapping(value = "getpiecebyCode/{code}", method = RequestMethod.GET)
	public PieceDeRecharge getPieceByCode(@PathVariable String code){
		return PieceService.getPiecebyCode(code);
	}
	@RequestMapping(value = "getallPiecesInIntervention/{id}", method = RequestMethod.GET)
	public List<PieceDeRecharge> getallPiecesInIntervention(@PathVariable("id") int id){
		return PieceService.getallPiecesInIntervention(id);
	}
	
	@RequestMapping(value = "addpiece", method = RequestMethod.POST)
	public String addMachine(@RequestBody PieceDeReChargeEntity piece) {
		return PieceService.addPiece(piece);
	}
	
	@RequestMapping(value = "updatepiece", method = RequestMethod.PUT)
	public String updateMachine(@RequestBody PieceDeReChargeEntity piece) {
		return PieceService.updatePiece(piece);
	}
	
	@RequestMapping(value = "deletepiece", method = RequestMethod.DELETE)
	public String removeMachine(@RequestBody PieceDeReChargeEntity piece) {
		return PieceService.removePiece(piece);
	}
}
