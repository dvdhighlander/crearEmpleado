package comco.employees.api.model;

import java.time.LocalDate;


public record EmployeeResponse (
		int id,
		String nombre,
		String apellido,
		String tipoDocumento,
		String documento,
		LocalDate fechaNacimiento,
		LocalDate fechaVinculacion,
		String cargo,
		double salario,
		String tiempoVinculacion,
		String edad) {


}
