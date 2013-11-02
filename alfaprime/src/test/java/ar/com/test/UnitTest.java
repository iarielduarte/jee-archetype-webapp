package ar.com.test;

import java.io.Serializable;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

import ar.com.model.bean.Rol;
import ar.com.model.bean.Usuario;
import ar.com.model.dao.HibernateDoa;
import ar.com.model.dao.IHibernateDao;
import ar.com.model.dao.UsuarioDao;
import ar.com.service.IRolService;
import ar.com.service.IUsuarioService;
import ar.com.service.UsuarioService;

//@ContextConfiguration(locations = { "classpath:WEB-INF/applicationContext.xml" })
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"file:src/main/webapp/WEB-INF/applicationContext.xml"})
public class UnitTest  {

	
	@Autowired  
    private ApplicationContext applicationContext; 
	
	@Autowired
	private IUsuarioService dao;

//	@BeforeClass
//	public void contextInit(){
//		
//	}

		

	@Test
	public void saveUser(){
		Usuario usu = new Usuario();
		Rol rol = new Rol();
		rol.setId(1);
		usu.setNombre("Ariel");
		usu.setRol(rol);
		usu.setEmail("@");
		usu.setClave("123");
		dao.deleteUsuario(usu);
//		Assert.assertNotNull(applicationContext.getBean("test"));
	}

	


}
