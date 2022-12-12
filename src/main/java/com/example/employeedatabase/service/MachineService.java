package com.example.employeedatabase.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeedatabase.entity.MachineEntity;
import com.example.employeedatabase.model.Machine;
import com.example.employeedatabase.repository.MachineRepository;

@Service
public class MachineService {
	@Autowired
	MachineRepository machineRepository;

	public List<Machine> getAllMachines() {

		try {
			List<MachineEntity> machines = machineRepository.findAll();
			List<Machine> custommachines = new ArrayList<>();
			machines.stream().forEach(c -> {
				Machine machine = new Machine();
				BeanUtils.copyProperties(c, machine);
				custommachines.add(machine);
			});
			return custommachines;
		} catch (Exception e) {
			throw e;
		}
	}

	public String addMachine(MachineEntity machine) {
		try {
			if (!machineRepository.existsByDesignation(machine.getDesignation())) {
				machineRepository.save(machine);
				return "Machine added successfully";
			} else {
				return "Machine Company already exists in the database.";
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public String removeMachine(MachineEntity machine) {
		try {
			if (machineRepository.existsByDesignation(machine.getDesignation())) {
				machineRepository.delete(machine);
				return "Machine deleted successfully.";
			} else {
				return "Machine does not exist.";
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public String updateMachine(MachineEntity machine) {
		try {
			if (machineRepository.existsByDesignation(machine.getDesignation())) {
				machineRepository.save(machine);
				return "Machine updated successfully.";
			} else {
				return "Machine does not exist.";
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public Machine getMachinebyCode(String code) {
		List<MachineEntity> machines = machineRepository.findAll();
		Machine machine = new Machine();
		MachineEntity m = machines.stream()
				.filter(t -> code.equals(t.getCode()))
				.findFirst()
				.orElse(null);

		BeanUtils.copyProperties(m, machine);
		return machine;
	}
	public List<Machine> getallMachinesInIntervention(int id) {
		List<MachineEntity> machines =machineRepository.getallMachinesInIntervention(id);
		List<Machine> customMachines = new ArrayList<>();
		machines.stream().forEach(m -> {
			Machine machine = new Machine();
			BeanUtils.copyProperties(m,machine);
			customMachines.add(machine);
		});
		return customMachines;
	}
}