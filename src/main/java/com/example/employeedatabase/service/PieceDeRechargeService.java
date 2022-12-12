package com.example.employeedatabase.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeedatabase.entity.PieceDeReChargeEntity;
import com.example.employeedatabase.model.PieceDeRecharge;
import com.example.employeedatabase.repository.PieceDeReChargeRepository;

@Service
public class PieceDeRechargeService {
	@Autowired
	PieceDeReChargeRepository piecederechargerepository;
	public List<PieceDeRecharge> getAllPieces() {

		try {
			List<PieceDeReChargeEntity> Pieces = piecederechargerepository.findAll();
			List<PieceDeRecharge> customPieces = new ArrayList<>();
			Pieces.stream().forEach(c -> {
				PieceDeRecharge Piece = new PieceDeRecharge();
				BeanUtils.copyProperties(c,Piece);
				customPieces.add(Piece);
			});
			return customPieces;
		} catch (Exception e) {
			throw e;
		}
	}
	public String addPiece(PieceDeReChargeEntity Piece) {
		try {
			if (!piecederechargerepository.existsByDesignation(Piece.getDesignation())) {
				piecederechargerepository.save(Piece);
				return "Piece added successfully";
			}else {
				return "Piece Company already exists in the database.";
			}
		}catch (Exception e) {
			throw e;
		}
	}
	public String removePiece(PieceDeReChargeEntity Piece) {
		try {
			if (piecederechargerepository.existsByDesignation(Piece.getDesignation())) {
				piecederechargerepository.delete(Piece);
				return "Piece deleted successfully.";
			} else {
				return "Piece does not exist.";
			}
		}catch (Exception e) {
			throw e;
		}
	}
	
	public String updatePiece(PieceDeReChargeEntity Piece) {
		try {
			if (piecederechargerepository.existsByDesignation(Piece.getDesignation())) {
				piecederechargerepository.save(Piece);
				return "Piece updated successfully.";
			} else {
				return "Piece does not exist.";
			}
		}catch (Exception e) {
			throw e;
		}
	}
	public PieceDeRecharge getPiecebyCode(String code) {
		List<PieceDeReChargeEntity> pieces = piecederechargerepository.findAll();
		PieceDeRecharge piece = new PieceDeRecharge();
		PieceDeReChargeEntity p = pieces.stream()
				.filter(t -> code.equals(t.getCode()))
				.findFirst()
				.orElse(null);

		BeanUtils.copyProperties(p, piece);
		return piece;
	}
	public List<PieceDeRecharge> getallPiecesInIntervention(int id) {
		List<PieceDeReChargeEntity> pieces =piecederechargerepository.getallPiecesInIntervention(id);
		List<PieceDeRecharge> customPieces = new ArrayList<>();
		pieces.stream().forEach(p -> {
			PieceDeRecharge piece = new PieceDeRecharge();
			BeanUtils.copyProperties(p,piece);
			customPieces.add(piece);
		});
		return customPieces;
		}
}
