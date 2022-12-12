package com.example.employeedatabase.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeedatabase.entity.CompanyEntity;
import com.example.employeedatabase.model.Company;
import com.example.employeedatabase.repository.CompanyRepository;

@Service
public class CompanyService {
	@Autowired
	CompanyRepository companyrepository;

	public List<Company> getAllCompanies() {

		try {
			List<CompanyEntity> Companies = companyrepository.findAll();
			List<Company> customCompanies = new ArrayList<>();
			Companies.stream().forEach(c -> {
				Company company = new Company();
				BeanUtils.copyProperties(c,company);
				customCompanies.add(company);
			});
			return customCompanies;
		} catch (Exception e) {
			throw e;
		}
	}
	public String addCompany(CompanyEntity company) {
		try {
			if (!companyrepository.existsBycompanyName(company.getCompanyName())) {
				companyrepository.save(company);
				return "Company added successfully";
			}else {
				return "This Company already exists in the database.";
			}
		}catch (Exception e) {
			throw e;
		}
	}
	public String removeCompany(CompanyEntity company) {
		try {
			if (companyrepository.existsBycompanyName(company.getCompanyName())) {
				companyrepository.delete(company);
				return "Company deleted successfully.";
			} else {
				return "Company does not exist.";
			}
		}catch (Exception e) {
			throw e;
		}
	}
	
	public String updateCompany(CompanyEntity company) {
		try {
			if (companyrepository.existsByMf(company.getMf())) {
				companyrepository.save(company);
				return "Company updated successfully.";
			} else {
				return "Company does not exist.";
			}
		}catch (Exception e) {
			throw e;
		}
	}
	public Company getCompanybyMf(String mf) {
		List<CompanyEntity> Companies = companyrepository.findAll();
		Company company = new Company();
		CompanyEntity c = Companies.stream()
				.filter(t -> mf.equals(t.getMf()))
				.findFirst()
				.orElse(null);
		BeanUtils.copyProperties(c,company);	
		    return company;
	}
	public Company getById(int id ) {
		CompanyEntity c =companyrepository.getById(id);
		Company company = new Company();
		BeanUtils.copyProperties(c,company);
		return company;
	}
}
