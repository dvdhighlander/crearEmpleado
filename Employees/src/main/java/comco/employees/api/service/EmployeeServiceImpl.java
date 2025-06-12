package comco.employees.api.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comco.employees.api.client.SaveRequest;
import comco.employees.api.client.SaveResponse;
import comco.employees.api.constants.EmployeesConstants;
import comco.employees.api.model.Employee;
import comco.employees.api.model.EmployeeResponse;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	  	@Autowired
	  	SaveEmployeeClient employeeClient;

	private DateTimeFormatter format = DateTimeFormatter.ofPattern(EmployeesConstants.DATE_FORMAT);

	@Override
	public EmployeeResponse saveEmployee(Employee employee) {

		SaveRequest request = new SaveRequest();
		request.setBirthdate(employee.birthdate().format(format));
		request.setDocument(employee.document().toString());
		request.setDocumentType(employee.documentType().toString());
		request.setName(employee.name().toString());
		request.setPosition(employee.position().toString());
		request.setSalary(employee.salary());
		request.setStartDate(employee.startDate().format(format));
		request.setSurename(employee.surename().toString());

		SaveResponse clientRta = employeeClient.saveEmployee(request);
		LocalDate birthdate=LocalDate.parse(clientRta.getBirthdate());
		LocalDate startDate=LocalDate.parse(clientRta.getStartDate());

		return new EmployeeResponse(clientRta.getId(), 
				clientRta.getName(), clientRta.getSurename(), clientRta.getDocumentType(), clientRta.getDocument(),
				birthdate, startDate, clientRta.getPosition(), clientRta.getSalary(), 
				getElapseTime(startDate), getElapseTime(birthdate));
	}

	private String getElapseTime(LocalDate time) {
		LocalDate now = LocalDate.now();
		StringBuilder elapsedBuilder = new StringBuilder();
		long years = time.until(now, ChronoUnit.YEARS);
		time = time.plusYears(years);
		if (years != 0) {
			elapsedBuilder.append(years);
			elapsedBuilder.append(" años");
		}

		long months = time.until(now, ChronoUnit.MONTHS);
		time = time.plusMonths(months);
		if (months != 0) {
			if (elapsedBuilder.length() != 0) {
				elapsedBuilder.append(", ");
			}
			elapsedBuilder.append(months);
			elapsedBuilder.append(" meses");
		}

		long days = time.until(now, ChronoUnit.DAYS);

		if (elapsedBuilder.length() != 0) {
			elapsedBuilder.append(" y ");
		}
		elapsedBuilder.append(days);
		elapsedBuilder.append(" dias");

		return elapsedBuilder.toString();
	}

}
