package com.example.employeedatabase.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class MachineEntity {
	@Id
	@Column (name = "code", nullable = false)
	public String code;
	public String designation;
	private int Qté_Disp;
	private int Qté_Stock;
	private int Qté_en_instance;
	@ManyToMany(mappedBy = "machines")
	private List<InterventionEntity> interventions;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getQté_Disp() {
		return Qté_Disp;
	}
	public void setQté_Disp(int qté_Disp) {
		Qté_Disp = qté_Disp;
	}
	public int getQté_Stock() {
		return Qté_Stock;
	}
	public void setQté_Stock(int qté_Stock) {
		Qté_Stock = qté_Stock;
	}
	public int getQté_en_instance() {
		return Qté_en_instance;
	}
	public void setQté_en_instance(int qté_en_instance) {
		Qté_en_instance = qté_en_instance;
	}
	public List<InterventionEntity> getInterventions() {
		return interventions;
	}
	public void setInterventions(List<InterventionEntity> interventions) {
		this.interventions = interventions;
	}
}
