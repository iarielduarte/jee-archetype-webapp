package ar.com.test;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;

import ar.com.model.bean.Rol;
import ar.com.model.dao.HibernateDoa;
import ar.com.model.dao.IHibernateDao;

@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
public class TestDao {

	
	@Resource
    private static IHibernateDao rolDao;
	
	public static void main(String[] args) {
		Rol rol = new Rol();
		rol.setId(1);
		rol.setNombre("Administrador");
		System.out.println("Hola");
//		rolDao = new HibernateDoa();
		rolDao.add(rol);

	}
	

}
