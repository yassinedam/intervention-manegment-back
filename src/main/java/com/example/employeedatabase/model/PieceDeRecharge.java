package com.example.employeedatabase.model;

public class PieceDeRecharge {
	private String Code;
	private String Designation;
	private int qte;
	private float prix;
	private float remise;
	private float TVA;
	private float total_HT;
	public PieceDeRecharge() {
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
}
