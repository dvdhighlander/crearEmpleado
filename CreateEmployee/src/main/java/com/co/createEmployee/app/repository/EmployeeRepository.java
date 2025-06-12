package com.co.createEmployee.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.createEmployee.app.model.Employee;



public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
