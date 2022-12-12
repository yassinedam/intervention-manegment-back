package com.example.employeedatabase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.employeedatabase.entity.ClientEntity;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {

	public boolean existsByFirstNameAndLastName(String firstname, String lastname);

	public boolean existsById(int id);
	
	@Query(value = "SELECT c FROM ClientEntity c join c.company WHERE c.company.mf=:mf")
	public List<ClientEntity> getallClientsInCompany(@Param("mf") String mf);

	@Query(value = "SELECT c FROM ClientEntity c join c.company WHERE c.id=:id")
	public ClientEntity getById(@Param("id") int id);
	@Query(value = "SELECT i.client FROM InterventionEntity i join i.client WHERE i.id=:id")
	public ClientEntity getClientByInterventionId(@Param("id") int id);

}
