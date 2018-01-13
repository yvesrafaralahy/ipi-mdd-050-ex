package com.ipiecoles.java.mdd050.endpoint;

import com.ipiecoles.java.mdd050.model.Employe;
import com.ipiecoles.java.mdd050.service.EmployeService;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
//import io.spring.guides.gs_producing_web_service.GetEmployeRequest;
//import io.spring.guides.gs_producing_web_service.GetEmployeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.time.ZoneId;
import java.util.GregorianCalendar;

//@Endpoint
public class EmployeEndpoint {

    /*@Autowired
    private EmployeService employeService;

    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeRequest")
    @ResponsePayload
    public GetEmployeResponse getEmploye(@RequestPayload GetEmployeRequest request) throws DatatypeConfigurationException {
        GetEmployeResponse response = new GetEmployeResponse();
        io.spring.guides.gs_producing_web_service.Employe employe = new io.spring.guides.gs_producing_web_service.Employe();

        Employe employe1 = employeService.findById(request.getId());
        employe.setId(employe1.getId());
        employe.setNom(employe1.getNom());
        employe.setPrenom(employe1.getPrenom());
        employe.setMatricule(employe1.getMatricule());
        if(employe1.getDateEmbauche() != null){
            employe.setDateEmbauche(DatatypeFactory.newInstance().newXMLGregorianCalendar(employe1.getDateEmbauche().toString("yyyy-MM-dd")));
        }

        response.setEmploye(employe);

        return response;
    }*/
}
