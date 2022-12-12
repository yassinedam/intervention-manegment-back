package com.example.employeedatabase.model;

public class Company {
	private long tel;
	private String companyName;
	private String adresse;
	private String Mf;
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Company() {
	}
	public long getTel() {
		return tel;
	}
	public void setTel(long tel) {
		this.tel = tel;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getMf() {
		return Mf;
	}
	public void setMf(String mf) {
		Mf = mf;
	}
	
}
