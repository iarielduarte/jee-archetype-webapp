package ar.com.sga.eis;

import java.util.List;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ar.com.sga.domain.Persona;
/**
 * 
 * @author Ariel Duarte
 *
 */

@Stateless
public class PersonaDaoImpl implements PersonaDao {

	@PersistenceContext(unitName="PersonaPU")
	EntityManager em;
	
	public List<Persona> findAllPersonas() {
		 return em.createNamedQuery("Persona.findAll").getResultList();
	}

	public Persona findPersonaById(Persona persona) {
		return em.find(Persona.class, persona.getPersonaId());
	}

	public Persona findPersonaByDni(Persona persona) {
		Query query = em.createQuery("from Persona p where p.perDni = :dni");
		query.setParameter("dni", persona.getPerDni());
		return (Persona) query.getSingleResult();
	}

	public void insertPersona(Persona persona) {
		em.persist(persona);

	}

	public void updatePersona(Persona persona) {
		em.merge(persona);

	}

	public void deletePersona(Persona persona) {
		em.merge(persona);
		em.remove(persona);

	}

}
