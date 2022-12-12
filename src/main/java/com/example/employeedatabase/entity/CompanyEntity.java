package com.example.employeedatabase.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CompanyEntity {
	@Id
	@Column (name = "mf", nullable = false)
	private String mf;
	private String companyName;
	private long tel;
	private String adresse;
	@OneToMany(mappedBy = "company", cascade = CascadeType.MERGE)
	private List<ClientEntity> Clients;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public List<ClientEntity> getClients() {
		return Clients;
	}

	public void setClients(List<ClientEntity> clients) {
		Clients = clients;
	}

	public String getMf() {
		return mf;
	}

	public void setMf(String mf) {
		this.mf = mf;
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

}
