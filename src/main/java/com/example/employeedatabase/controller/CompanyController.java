package com.example.employeedatabase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeedatabase.entity.CompanyEntity;
import com.example.employeedatabase.model.Company;
import com.example.employeedatabase.service.CompanyService;

@RestController
@CrossOrigin(origins = "*")
public class CompanyController {
	@Autowired
	CompanyService companyService;
	@RequestMapping(value = "getallcompanies", method = RequestMethod.GET)
	public List<Company> getAllCompanies(){
		return companyService.getAllCompanies();
	}
	@RequestMapping(value = "getcompanybymf/{mf}", method = RequestMethod.GET)
	public Company getCompanybymf(@PathVariable("mf") String mf){
		return companyService.getCompanybyMf(mf);
	}
	
	@RequestMapping(value = "addcompany", method = RequestMethod.POST)
	public String addCompany(@RequestBody CompanyEntity Company) {
		return companyService.addCompany(Company);
	}
	@RequestMapping(value = "getcompanybyclientid/{id}", method = RequestMethod.GET)
	public Company getCompany(@PathVariable int id){
		return companyService.getById(id);
	}
	
	@RequestMapping(value = "updatecompany", method = RequestMethod.PUT)
	public String updateCompany(@RequestBody CompanyEntity Company) {
		return companyService.updateCompany(Company);
	}
	
	@RequestMapping(value = "deletecompany", method = RequestMethod.DELETE)
	public String removeCompany(@RequestBody CompanyEntity Company) {
		return companyService.removeCompany(Company);
	}
}
