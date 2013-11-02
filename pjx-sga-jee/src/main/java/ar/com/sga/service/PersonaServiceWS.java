package ar.com.sga.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import ar.com.sga.domain.Persona;

@WebService
public interface PersonaServiceWS {

	@WebMethod
	public List<Persona> listarPersonas();
	
}
