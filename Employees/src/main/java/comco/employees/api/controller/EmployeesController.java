package comco.employees.api.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import comco.employees.api.constants.EmployeesConstants;
import comco.employees.api.model.Employee;
import comco.employees.api.model.EmployeeResponse;
import comco.employees.api.service.EmployeeServiceImpl;
import comco.employees.api.validation.DateValidation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeesController {
	@Autowired
	private EmployeeServiceImpl employeeService;
	
	@GetMapping("/create")
	@ResponseBody
	public EmployeeResponse createEmployee(
			@RequestParam(required = true, name = "nombre") String name,
			@RequestParam(required = true, name = "apellido") String surename,
			@RequestParam(required = true, name = "tipoDocumento") String documentType,
			@RequestParam(required = true, name = "numeroDocumento") String document,
			@RequestParam(required = true, name = "fechaNacimiento") @Valid @DateValidation() @DateTimeFormat(pattern = EmployeesConstants.DATE_FORMAT) LocalDate birthdate,
			@RequestParam(required = true, name = "fechaVinculacion") @DateTimeFormat(pattern = EmployeesConstants.DATE_FORMAT) LocalDate startDate,
			@RequestParam(required = true, name = "cargo") String position,
			@RequestParam(required = true, name = "salario") double salary) {
		Employee employeeDTO = new Employee(name, surename, documentType, document, birthdate, startDate, position,
				salary);
		return  employeeService.saveEmployee(employeeDTO);
	}
}
