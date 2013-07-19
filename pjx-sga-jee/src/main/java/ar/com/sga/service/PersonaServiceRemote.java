package ar.com.sga.service;

import java.util.List;

import javax.ejb.Remote;

import ar.com.sga.domain.Persona;

@Remote
public interface PersonaServiceRemote {

	public List<Persona> listarPersonas();
	public Persona encontrarPersonaById(Persona persona);
	public Persona encontrarPersonaByEmail(Persona persona);
	public void guardaPersona(Persona persona);
	public void modificarPersona(Persona persona);
	public void eliminarPersona(Persona persona);
}
