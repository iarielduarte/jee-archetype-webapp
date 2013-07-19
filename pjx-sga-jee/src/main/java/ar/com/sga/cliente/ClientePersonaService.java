package ar.com.sga.cliente;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ar.com.sga.domain.Persona;
import ar.com.sga.service.PersonaServiceRemote;

public class ClientePersonaService {

	public static void main(String[] args) {
		System.out.println("Iniciando llamada al EJB desde el cliente /n");
		
		Context jndi;
		try {
			jndi = new InitialContext();
			PersonaServiceRemote personaService =
					(PersonaServiceRemote) jndi.lookup("java:global/pjx-sga-jee/PersonaServiceImp!ar.com.sga.service.PersonaServiceRemote");
		
		List<Persona> personas = personaService.listarPersonas();
		for (Persona persona : personas) {
			System.out.println(persona);
		}
		System.out.println("\n Fin llamada al EJB desde el cliente");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
