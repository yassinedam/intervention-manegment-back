package com.example.employeedatabase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.employeedatabase.entity.InterventionEntity;

public interface InterventionRepository extends JpaRepository<InterventionEntity, Integer> {
	public boolean existsByNumeroIntervention(int num_intervention);
	public boolean existsById(int id);
	@Query(value = "SELECT i FROM InterventionEntity i join i.intervenants e  WHERE e.id=:id")
	public List<InterventionEntity> getallInterventionForClient(@Param("id") int id);
}
