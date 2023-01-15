package com.emp.repository;

import org.springframework.data.repository.CrudRepository;

import com.emp.employee.Employee;

public interface EmpRepository extends CrudRepository<Employee, Integer>{

}
