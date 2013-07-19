package ar.com.jee.test;

import static org.junit.Assert.assertEquals;

import javax.ejb.embeddable.EJBContainer;

import org.junit.Before;
import org.junit.Test;

import ar.com.jee.beans.SampleEJB;

import javax.naming.Context;

public class SampleEJBUnitTest {

	private static EJBContainer contenedor;
	private static Context contexto;
	private static SampleEJB ejb;


	@Before
	public void setUp() throws Exception {
		System.out.println("---Iniciando EJB container");
		contenedor = EJBContainer.createEJBContainer();
		contexto=contenedor.getContext();
		ejb=(SampleEJB) contexto.lookup("java:global/classes/SampleEJB!ar.com.jee.beans.SampleEJB");
	}

	@Test
	public void testAddNumbers() {
		int dato1=3;
		int dato2=5;
		int resultado=ejb.sumar(dato1, dato2);
		assertEquals((dato1+dato2),resultado);
		System.out.println("Resultado esperado: "+resultado);
	}

}
