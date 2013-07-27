package ar.com.sga.eis;

import java.util.List;

import ar.com.sga.domain.Persona;

public interface PersonaDao {
	
	public List<Persona> findAllPersonas();
	
	public Persona findPersonaById(Persona persona);
	
	public Persona findPersonaByDni(Persona persona);
	
	public void insertPersona(Persona persona);
	
	public void updatePersona(Persona persona);
	
	public void deletePersona(Persona persona);

}
