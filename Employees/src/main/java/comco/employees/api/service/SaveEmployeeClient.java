package comco.employees.api.service;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import comco.employees.api.client.SaveRequest;
import comco.employees.api.client.SaveResponse;

public class SaveEmployeeClient  extends WebServiceGatewaySupport {

    public SaveResponse saveEmployee(SaveRequest request) {

    	SaveResponse response = (SaveResponse) getWebServiceTemplate()
          .marshalSendAndReceive(request);
        return response;
    }
}