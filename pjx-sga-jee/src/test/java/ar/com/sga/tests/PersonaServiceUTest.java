package ar.com.sga.tests;

import static org.junit.Assert.*;

import java.util.List;

import javax.ejb.embeddable.EJBContainer;

import org.junit.Before;
import org.junit.Test;

import ar.com.sga.domain.Persona;
import ar.com.sga.service.PersonaService;

public class PersonaServiceUTest {

	private PersonaService personaService;
	@Before
	public void setUp() throws Exception {
		EJBContainer contenedor = EJBContainer.createEJBContainer();
		personaService = 
				(PersonaService) contenedor.getContext().
				lookup("java:global/classes/PersonaServiceImp!ar.com.sga.service.PersonaService");
	}

	@Test
	public void PersonaServiceEJBtest() {
		System.out.println("Ininciando test EJB PersonasSevice");
		assertTrue(personaService!=null);
		
		assertEquals(2,personaService.listarPersonas().size());
		System.out.println("Resultado esperado 2: El Nro de personas es :"+personaService.listarPersonas().size());
		
		this.desplegarPersonas(personaService.listarPersonas());
		System.out.println("Fin de EJB Test-------------------");
	}

	private void desplegarPersonas(List<Persona> listarPersonas) {
		for (Persona persona : listarPersonas) {
			System.out.println(persona);
		}
		
	}

}
