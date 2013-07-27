package ar.com.sga.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ar.com.sga.domain.Persona;
import ar.com.sga.eis.PersonaDao;

@Stateless
public class PersonaServiceImp implements PersonaServiceRemote, PersonaService{

	@EJB
	private PersonaDao personaDao;
	
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
