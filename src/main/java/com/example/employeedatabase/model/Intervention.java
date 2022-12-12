package com.example.employeedatabase.model;

import java.util.List;

public class Intervention {
	private int id;
	private Client client;
	private String date;
	private String durée;
	private int num_intervention;
	private int nb_device;
	private String nature_intervention;
	private String description_intervention;
	private String observation;
	private List<Employee> intervenants;
	private List<Machine> machines;
	private List<PieceDeRecharge> piece_de_recharge;
	public Intervention() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDurée() {
		return durée;
	}
	public void setDurée(String durée) {
		this.durée = durée;
	}
	public int getNum_intervention() {
		return num_intervention;
	}
	public void setNum_intervention(int num_intervention) {
		this.num_intervention = num_intervention;
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
	public List<Employee> getIntervenants() {
		return intervenants;
	}
	public void setIntervenants(List<Employee> intervenants) {
		this.intervenants = intervenants;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public void addIntervenants(Employee e) {
		this.intervenants.add(e);
	}
	public void removeIntervenants(Employee e) {
		this.intervenants.remove(e);
	}
	public List<Machine> getMachines() {
		return machines;
	}
	public void setMachines(List<Machine> machines) {
		this.machines = machines;
	}
	public List<PieceDeRecharge> getPiece_de_recharge() {
		return piece_de_recharge;
	}
	public void setPiece_de_recharge(List<PieceDeRecharge> piece_de_recharge) {
		this.piece_de_recharge = piece_de_recharge;
	}
}
