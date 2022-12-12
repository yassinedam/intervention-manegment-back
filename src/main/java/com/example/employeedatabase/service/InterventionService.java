package com.example.employeedatabase.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeedatabase.entity.InterventionEntity;
import com.example.employeedatabase.model.Client;
import com.example.employeedatabase.model.Intervention;
import com.example.employeedatabase.repository.InterventionRepository;



@Service
public class InterventionService {
	@Autowired
	InterventionRepository interventionRepository;

	public List<Intervention> getAllInterventions() {

		try {
			List<InterventionEntity> interventions = interventionRepository.findAll();
			List<Intervention> custominterventions = new ArrayList<>();
			interventions.stream().forEach(c -> {
				Intervention intervention= new Intervention();
				BeanUtils.copyProperties(c,intervention);
				custominterventions.add(intervention);
			});
			return custominterventions;
		} catch (Exception e) {
			throw e;
		}
	}
	public String addIntervention(InterventionEntity intervention) {
		try {
			if (!interventionRepository.existsByNumeroIntervention(intervention.getNum_intervention())) {
				interventionRepository.save(intervention);
				return "Intervention added successfully";
			}else {
				return "Intervention Company already exists in the database.";
			}
		}catch (Exception e) {
			throw e;
		}
	}
	public String removeIntervention(InterventionEntity intervention) {
		try {
			if (interventionRepository.existsByNumeroIntervention(intervention.getNum_intervention())) {
				interventionRepository.delete(intervention);
				return "Intervention deleted successfully.";
			} else {
				return "Intervention does not exist.";
			}
		}catch (Exception e) {
			throw e;
		}
	}
	
	public String updateIntervention(InterventionEntity intervention) {
		try {
			if (interventionRepository.existsById(intervention.getId())) {
				interventionRepository.save(intervention);
				return "Intervention updated successfully.";
			} else {
				return "Intervention does not exist.";
			}
		}catch (Exception e) {
			throw e;
		}
	}
	public List<Intervention> getAllInterventionsByClient(Client client) {

		try {
			List<InterventionEntity> interventions = interventionRepository.findAll();
			List<Intervention> custominterventions = new ArrayList<>();
			interventions.stream().forEach(c -> {
				Intervention intervention= new Intervention();
				if(c.getClient().getId()==client.getId()){
				BeanUtils.copyProperties(c,intervention);
				custominterventions.add(intervention);
				}});
			return custominterventions;
		} catch (Exception e) {
			throw e;
		}
	}
	public List<Intervention> getAllInterventionsForIntervenant(int id) {
		List<InterventionEntity> interventions =interventionRepository.getallInterventionForClient(id);
		List<Intervention> customInterventions = new ArrayList<>();
		interventions.stream().forEach(i -> {
			Intervention intervention = new Intervention();
			BeanUtils.copyProperties(i,intervention);
			customInterventions.add(intervention);
		});
		return customInterventions;
	}
}
