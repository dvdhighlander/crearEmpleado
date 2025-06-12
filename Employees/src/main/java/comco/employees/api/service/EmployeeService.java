package comco.employees.api.service;

import java.util.Optional;

import comco.employees.api.model.Employee;
import comco.employees.api.model.EmployeeResponse;

public interface EmployeeService {

	public abstract EmployeeResponse saveEmployee(Employee employee);
}
