package com.example.employeedatabase.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeedatabase.entity.EmployeeEntity;
import com.example.employeedatabase.model.Employee;
import com.example.employeedatabase.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees(){
		
		try {
			List<EmployeeEntity> employees = employeeRepository.findAll();
			List<Employee> customEmployees = new ArrayList<>();
			employees.stream().forEach(e -> {
				Employee employee = new Employee();
				BeanUtils.copyProperties(e, employee);
				customEmployees.add(employee);
			});
			return customEmployees;
		}catch(Exception e) {
			throw e;
		}
	}
	
	public String addEmployee(EmployeeEntity employee) {
		try {
			if (!employeeRepository.existsByFirstNameAndLastName(employee.getFirstName(), employee.getLastName())) {
				employeeRepository.save(employee);
				return "Employee added successfully";
			}else {
				return "This employee already exists in the database.";
			}
		}catch (Exception e) {
			throw e;
		}
	}
	
	public String removeEmployee(EmployeeEntity employee) {
		try {
			if (employeeRepository.existsByFirstNameAndLastName(employee.getFirstName(), employee.getLastName())) {
				employeeRepository.delete(employee);
				return "Employee deleted successfully.";
			} else {
				return "Employee does not exist.";
			}
		}catch (Exception e) {
			throw e;
		}
	}
	
	public String updateEmployee(EmployeeEntity employee) {
		try {
			if (employeeRepository.existsById(employee.getId())) {
				employeeRepository.save(employee);
				return "Employee updated successfully.";
			} else {
				return "Employee does not exist.";
			}
		}catch (Exception e) {
			throw e;
		}
	}
	public Employee getEmployeebyId(int id) {
		EmployeeEntity e =employeeRepository.getById(id);
		Employee employee = new Employee();
		BeanUtils.copyProperties(e,employee);
		return employee;
	}
	public List<Employee> getallIntervenatnsInIntervention(int id) {
		List<EmployeeEntity> employees =employeeRepository.getallIntervenatnsInIntervention(id);
		List<Employee> customEmployees = new ArrayList<>();
		employees.stream().forEach(e -> {
			Employee employee = new Employee();
			BeanUtils.copyProperties(e,employee);
			customEmployees.add(employee);
		});
		return customEmployees;
		}
	public Employee getEmployeeForUser(int id ) {
		EmployeeEntity e =employeeRepository.getEmployeeForUser(id);
		Employee employee = new Employee();
		BeanUtils.copyProperties(e,employee);
		return employee;
	}
	
}
