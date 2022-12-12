package com.example.employeedatabase.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeedatabase.entity.ClientEntity;
import com.example.employeedatabase.model.Client;
import com.example.employeedatabase.repository.ClientRepository;

@Service
public class ClientService {
	@Autowired
	ClientRepository clientRepository;

	public List<Client> getAllClients() {

		try {
			List<ClientEntity> Clients = clientRepository.findAll();
			List<Client> customClients = new ArrayList<>();
			Clients.stream().forEach(c -> {
				Client client = new Client();
				BeanUtils.copyProperties(c,client);
				customClients.add(client);
			});
			return customClients;
		} catch (Exception e) {
			throw e;
		}
	}
	public String addClient(ClientEntity client) {
		try {
			if (!clientRepository.existsByFirstNameAndLastName(client.getFirstname(),client.getLastname())) {
				clientRepository.save(client);
				return "Client added successfully";
			}else {
				return "Client Company already exists in the database.";
			}
		}catch (Exception e) {
			throw e;
		}
	}
	public String removeClient(ClientEntity client) {
		try {
			if (clientRepository.existsByFirstNameAndLastName(client.getFirstname(),client.getLastname())) {
				clientRepository.delete(client);
				return "Client deleted successfully.";
			} else {
				return "Client does not exist.";
			}
		}catch (Exception e) {
			throw e;
		}
	}
	
	public String updateClient(ClientEntity client) {
		try {
			if (clientRepository.existsById(client.getId())) {
				clientRepository.save(client);
				return "Client updated successfully.";
			} else {
				return "Client does not exist.";
			}
		}catch (Exception e) {
			throw e;
		}
	}
	public Client getById(int id ) {
		ClientEntity c =clientRepository.getById(id);
		Client client = new Client();
		BeanUtils.copyProperties(c,client);
		return client;
	}
	public Client getClientByInterventionId(int id ) {
		ClientEntity c =clientRepository.getClientByInterventionId(id);
		Client client = new Client();
		BeanUtils.copyProperties(c,client);
		return client;
	}
	public List<Client> getallClientsInCompany(String mf) {
		List<ClientEntity> clients =clientRepository.getallClientsInCompany(mf);
		List<Client> customClients = new ArrayList<>();
		clients.stream().forEach(c -> {
			Client client = new Client();
			BeanUtils.copyProperties(c,client);
			customClients.add(client);
		});
		return customClients;
	}
	
}
