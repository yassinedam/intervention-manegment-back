package com.example.employeedatabase.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class PieceDeReChargeEntity {
	@Id
	@Column (name = "code", nullable = false)
	public String code;
	public String designation;
	private int qte;
	private float prix;
	private float remise;
	private float TVA;
	private float total_HT;
	@ManyToMany(mappedBy = "pieces_de_recharge")
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
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public float getRemise() {
		return remise;
	}
	public void setRemise(float remise) {
		this.remise = remise;
	}
	public float getTVA() {
		return TVA;
	}
	public void setTVA(float tVA) {
		TVA = tVA;
	}
	public float getTotal_HT() {
		return total_HT;
	}
	public void setTotal_HT(float total_HT) {
		this.total_HT = total_HT;
	}
	public List<InterventionEntity> getInterventions() {
		return interventions;
	}
	public void setInterventions(List<InterventionEntity> interventions) {
		this.interventions = interventions;
	}
}
