package comco.employees.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeesApplicationTests {

    @Autowired
    private MockMvc mockMvc;
    
	@Test
	public void successIfServiceResponseOK() throws Exception {

	    mockMvc.perform(MockMvcRequestBuilders.get("/employee/create")
	            .param("nombre", "testName")
	            .param("apellido", "testApellido")
	            .param("tipoDocumento", "CC")
	            .param("numeroDocumento", "1098765432")
	            .param("fechaNacimiento", "2000-01-21")
	            .param("fechaVinculacion", "2025-01-03")
	            .param("cargo", "testCargo")
	            .param("salario", "123456")
	            )
	            .andExpect(MockMvcResultMatchers.status().isOk());
	}
}