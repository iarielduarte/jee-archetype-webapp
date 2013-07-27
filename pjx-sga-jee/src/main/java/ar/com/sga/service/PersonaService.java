package ar.com.sga.service;

import java.util.List;

import javax.ejb.Local;

import ar.com.sga.domain.Persona;

@Local
public interface PersonaService {
	public List<Persona> listarPersonas();
	public Persona encontrarPersonaById(Persona persona);
	public Persona encontrarPersonaByDni(Persona persona);
	public void guardaPersona(Persona persona);
	public void modificarPersona(Persona persona);
	public void eliminarPersona(Persona persona);
}
