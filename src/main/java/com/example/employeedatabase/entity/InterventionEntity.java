package com.example.employeedatabase.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class InterventionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_client")
	private ClientEntity client;
	private String date;
	private int durée;
	public int numeroIntervention;
	private int nb_device;
	private String nature_intervention;
	private String description_intervention;
	private String observation;	
	@ManyToMany
	private List<EmployeeEntity> intervenants;
	@ManyToMany
	private List<MachineEntity> machines;
	@ManyToMany
	private List<PieceDeReChargeEntity> pieces_de_recharge;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ClientEntity getClient() {
		return client;
	}
	public void setClient(ClientEntity client) {
		this.client = client;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getDurée() {
		return durée;
	}
	public void setDurée(int durée) {
		this.durée = durée;
	}
	public int getNum_intervention() {
		return numeroIntervention;
	}
	public void setNum_intervention(int numeroIntervention) {
		this.numeroIntervention = numeroIntervention;
	}
	public int getNb_device() {
		return nb_device;
	}
	public void setNb_device(int nb_device) {
		this.nb_device = nb_device;
	}
	public String getNature_intervention() {
		return nature_intervention;
	}
	public void setNature_intervention(String nature_intervention) {
		this.nature_intervention = nature_intervention;
	}
	public String getDescription_intervention() {
		return description_intervention;
	}
	public void setDescription_intervention(String description_intervention) {
		this.description_intervention = description_intervention;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public List<EmployeeEntity> getIntervenants() {
		return intervenants;
	}
	public void setIntervenants(List<EmployeeEntity> intervenant) {
		this.intervenants = intervenant;
	}
	public List<MachineEntity> getMachines() {
		return machines;
	}
	public void setMachines(List<MachineEntity> machines) {
		this.machines = machines;
	}
	public List<PieceDeReChargeEntity> getPiece_de_recharge() {
		return pieces_de_recharge;
	}
	public void setPiece_de_recharge(List<PieceDeReChargeEntity> piece_de_recharge) {
		this.pieces_de_recharge = piece_de_recharge;
	}
	
}
