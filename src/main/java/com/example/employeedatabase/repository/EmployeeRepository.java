package com.example.employeedatabase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.employeedatabase.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

	public boolean existsByFirstNameAndLastName(String firstName,  String lastName);
	
	public boolean existsById(int id);
	@Query(value = "SELECT e FROM EmployeeEntity e WHERE e.id=:id")
	public EmployeeEntity getById(@Param("id") int id);
	@Query(value = "SELECT i.intervenants FROM InterventionEntity i join i.intervenants WHERE i.id=:id")
	public List<EmployeeEntity> getallIntervenatnsInIntervention(@Param("id") int id);
	@Query(value = "SELECT e FROM EmployeeEntity e join e.users u WHERE u.identity=:id")
	public EmployeeEntity getEmployeeForUser(@Param("id") int id);
}
