package com.example.employeedatabase.model;

public class Machine {
	private String Code;
	private String Designation;
	private int Qté_Disp;
	private int Qté_Stock;
	private int Qté_en_instance;
	public Machine() {
	}
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
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
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public String getCatégorie() {
		return Catégorie;
	}
	public void setCatégorie(String catégorie) {
		Catégorie = catégorie;
	}
	public String getFamille() {
		return Famille;
	}
	public void setFamille(String famille) {
		Famille = famille;
	}
	private float prix;
	private String Catégorie;
	private String Famille;
}
