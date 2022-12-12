package com.example.employeedatabase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.employeedatabase.entity.MachineEntity;

public interface MachineRepository extends JpaRepository<MachineEntity, String> {
	public boolean existsByDesignation(String designation);
	public boolean existsByCode(String code);
	@Query(value = "SELECT i.machines FROM InterventionEntity i join i.machines WHERE i.id=:id")
	public List<MachineEntity> getallMachinesInIntervention(@Param("id") int id);

}
