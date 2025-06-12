package com.co.createEmployee.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.co.createEmployee.app.client.SaveRequest;
import com.co.createEmployee.app.client.SaveResponse;
import com.co.createEmployee.app.constants.CreateEmployeeConstants;
import com.co.createEmployee.app.model.Employee;
import com.co.createEmployee.app.repository.EmployeeRepository;

@Endpoint
public class EmployeeEndpoint {
	private static final String NAMESPACE_URI = CreateEmployeeConstants.NAMESPACE;
	private final EmployeeRepository dataRepository;

	public EmployeeEndpoint(EmployeeRepository dataRepository) {
		this.dataRepository = dataRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = CreateEmployeeConstants.SOAP_LOCALPART)
	@ResponsePayload
	public SaveResponse save(@RequestPayload SaveRequest request) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(CreateEmployeeConstants.DATE_FORMAT);
		checkBirthdate(LocalDate.parse(request.getBirthdate()));
		Employee dataEntity = new Employee();
		dataEntity.setNombre(request.getName());
		dataEntity.setApellido(request.getSurename());
		dataEntity.setTipoDocumento(request.getDocumentType());
		dataEntity.setDocumento(request.getDocument());
		dataEntity.setFechaNacimiento(sdf.parse(request.getBirthdate()));
		dataEntity.setFechaVinculacion(sdf.parse(request.getStartDate()));
		dataEntity.setCargo(request.getPosition());
		dataEntity.setSalario(request.getSalary());
		SaveResponse response = new SaveResponse();
		try {
			Employee rta = dataRepository.save(dataEntity);
			response.setMessage(CreateEmployeeConstants.OK_MESSAGE);
			response.setBirthdate(sdf.format(rta.getFechaNacimiento()));
			response.setStartDate(sdf.format(rta.getFechaVinculacion()));
			response.setDocument(rta.getDocumento());
			response.setDocumentType(rta.getTipoDocumento());
			response.setId(rta.getId());
			response.setName(rta.getNombre());
			response.setPosition(rta.getCargo());
			response.setSalary(rta.getSalario());
			response.setSurename(rta.getApellido());
		} catch (Exception e) {
			response.setMessage(CreateEmployeeConstants.ERROR_MESSAGE + e.getMessage());
		}
		return response;
	}

	private void checkBirthdate(LocalDate date) {
		LocalDate currentDate = LocalDate.now();
		Period period = Period.between(date, currentDate);

		if (period.getYears() < 18) {
			throw new IllegalArgumentException(CreateEmployeeConstants.AGE_NOT_ALLOWED);
		}

	}
}
