package ar.com.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import ar.com.model.bean.Rol;

@Repository
public class RolDao implements IRolDao, Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private SessionFactory sessionFactory;
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addRol(Rol rol) {
		getSessionFactory().getCurrentSession().save(rol);
		
	}

	@Override
	public void updateRol(Rol rol) {
		getSessionFactory().getCurrentSession().update(rol);
		
	}

	@Override
	public void deleteRol(Rol rol) {
		getSessionFactory().getCurrentSession().delete(rol);
		
	}

	@Override
	public Rol getRolById(int id) {
		List list = getSessionFactory().getCurrentSession().createQuery("FROM Rol WHERE id=?").setParameter(0, id).list();
		return (Rol) list.get(0);
	}

	@Override
	public List<Rol> getRols() {
		List list = getSessionFactory().getCurrentSession().createQuery("FROM Rol").list();
		return list;
	}
	
}
