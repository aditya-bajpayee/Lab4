package com.emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.emp.employee.Employee;
import com.emp.repository.EmpRepository;

@Service
public class ServiceEmp {
	
	@Autowired
	private EmpRepository empRepository;
	
	public Employee saveEmp(Employee employee) {
		this.empRepository.save(employee);
		return employee;
	}
	
	public List<Employee> getAllProducts() {
		List<Employee> emp=(List<Employee>)empRepository.findAll();
		return emp;
		
	}
	public Employee getEmp(int eId) {
		Optional<Employee> optional=this.empRepository.findById(eId);
		Employee employee= optional.get();
		return employee;
	}

	
	public void deleteEmployeeId(int id) {
		this.empRepository.deleteById(id);
	}
}
