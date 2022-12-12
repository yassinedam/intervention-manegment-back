package com.example.employeedatabase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.employeedatabase.entity.PieceDeReChargeEntity;


public interface PieceDeReChargeRepository extends JpaRepository<PieceDeReChargeEntity, String> {
	public boolean existsByDesignation(String designation);
	public boolean existsByCode(String code);
	@Query(value = "SELECT i.pieces_de_recharge FROM InterventionEntity i join i.pieces_de_recharge WHERE i.id=:id")
	public List<PieceDeReChargeEntity> getallPiecesInIntervention(@Param("id") int id);
}
