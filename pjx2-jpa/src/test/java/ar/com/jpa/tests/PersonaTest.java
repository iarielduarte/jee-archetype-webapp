package ar.com.jpa.tests;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ar.com.jpa.beans.dominio.Persona;

public class PersonaTest {
	
	static EntityManager em = null;
	static EntityTransaction et =null;
	static EntityManagerFactory emf=null;
    Logger log = Logger.getLogger("PersonaTest");
	
	@BeforeClass
	public static void init() throws Exception{
		emf = Persistence.createEntityManagerFactory("PersonaPU");
	}
    
    @Before
	public void setUp() throws Exception {
    	try {
			em = emf.createEntityManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testPersonaEntity() {
		log.debug("Iniciando test unitario de la entidad Persona con JPA");
		assertTrue(em != null);
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//No es necesario especificar el ID de Persona, es autoincremental
		Persona persona1 = new Persona("Michelle","Olmedo","22223333","mi@gmail.com","34544");
		
		log.debug("Objeto a persistir "+persona1);
		
		em.persist(persona1);
		
		tx.commit();
		
		log.debug("Objeto a persistir "+persona1);
		
		log.debug("Fin de test----");
		
		
	}

}
