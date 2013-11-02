package ar.com.sga.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import ar.com.sga.domain.Persona;
import ar.com.sga.eis.PersonaDao;

@Stateless
@WebService(endpointInterface="ar.com.sga.service.PersonaServiceWS")
public class PersonaServiceImpl implements PersonaServiceRemote, PersonaService, PersonaServiceWS{

	@EJB
	private PersonaDao personaDao;
	
	@Override
	public List<Persona> listarPersonas() {
		return personaDao.findAllPersonas();
	}

	public Persona encontrarPersonaById(Persona persona) {
		return personaDao.findPersonaById(persona);
	}

	public Persona encontrarPersonaByDni(Persona persona) {
		return personaDao.findPersonaByDni(persona);
	}

	public void guardaPersona(Persona persona) {
		personaDao.insertPersona(persona);

	}

	public void modificarPersona(Persona persona) {
		personaDao.updatePersona(persona);

	}

	public void eliminarPersona(Persona persona) {
		personaDao.deletePersona(persona);

	}

}
