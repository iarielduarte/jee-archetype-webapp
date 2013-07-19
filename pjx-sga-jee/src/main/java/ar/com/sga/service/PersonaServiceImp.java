package ar.com.sga.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import ar.com.sga.domain.Persona;

@Stateless
public class PersonaServiceImp implements PersonaServiceRemote, PersonaServiceLocal {

	public List<Persona> listarPersonas() {
		List<Persona>personas=new ArrayList<Persona>();
		personas.add(new Persona(1,"Ariel","Duarte","Kind","arielpy@gmail.com","2345678"));
		personas.add(new Persona(2,"Reynaldo","Duarte","Kind","arielpy@gmail.com","2345678"));
		return personas;
	}

	public Persona encontrarPersonaById(Persona persona) {
		// TODO Auto-generated method stub
		return null;
	}

	public Persona encontrarPersonaByEmail(Persona persona) {
		// TODO Auto-generated method stub
		return null;
	}

	public void guardaPersona(Persona persona) {
		// TODO Auto-generated method stub

	}

	public void modificarPersona(Persona persona) {
		// TODO Auto-generated method stub

	}

	public void eliminarPersona(Persona persona) {
		// TODO Auto-generated method stub

	}

}
