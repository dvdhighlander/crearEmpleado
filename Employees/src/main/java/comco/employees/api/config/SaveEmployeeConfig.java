package comco.employees.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import comco.employees.api.constants.EmployeesConstants;
import comco.employees.api.service.SaveEmployeeClient;

@Configuration
public class SaveEmployeeConfig {

	
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(EmployeesConstants.CLIENT_DIR);
        return marshaller;
    }
    @Bean
    public SaveEmployeeClient countryClient(Jaxb2Marshaller marshaller) {
    	SaveEmployeeClient client = new SaveEmployeeClient();
        client.setDefaultUri(EmployeesConstants.SOAP_URL_DEFAULT);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
