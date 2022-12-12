package com.example.employeedatabase.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ClientEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	public String firstName;
	public String lastName;
	private String Email;
	private long tel;
	@ManyToOne(fetch= FetchType.LAZY,cascade = CascadeType.MERGE)
	@JoinColumn(name="company_mf", referencedColumnName="mf")
	private CompanyEntity company;
	@OneToMany(mappedBy = "client")
	private List<InterventionEntity> interventions;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstName;
	}

	public void setFirstname(String firstname) {
		this.firstName = firstname;
	}

	public String getLastname() {
		return lastName;
	}

	public void setLastname(String lastname) {
		this.lastName = lastname;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public long getTel() {
		return tel;
	}

	public void setTel(long tel) {
		this.tel = tel;
	}

	public CompanyEntity getCompany() {
		return company;
	}

	public void setCompany(CompanyEntity company) {
		this.company = company;
	}

	public List<InterventionEntity> getInterventions() {
		return interventions;
	}

	public void setInterventions(List<InterventionEntity> interventions) {
		this.interventions = interventions;
	}
}
