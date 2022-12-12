package com.example.employeedatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.employeedatabase.entity.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer> {
	public boolean existsBycompanyName(String companyName);
	public boolean existsByMf(String mf);
	public boolean existsById(int id);
	@Query(value = "SELECT c.company FROM ClientEntity c join c.company WHERE c.id=:id")
	public CompanyEntity getById(@Param("id") int id);
}
