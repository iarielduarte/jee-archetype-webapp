package ar.com.model.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class HibernateDoa<E, ID extends Serializable> extends HibernateDaoSupport
	implements IHibernateDao<E, ID> {
	
	private Class<E> clazz;


	@Autowired
	private SessionFactory sessionFactory;
	

	
		
	
	public E getByID(ID id) {
		return (E) sessionFactory.getCurrentSession().get(clazz, id);
	}
	
	
	public void add(E entity) {
		sessionFactory.getCurrentSession().save(entity);
		
	}

	
	public void update(E entity) {
		sessionFactory.getCurrentSession().update(entity);
		
	}

	
	public void delete(E entity) {
		sessionFactory.getCurrentSession().delete(entity);
		
	}


	public List<E> getList() {
		 return sessionFactory.getCurrentSession().createQuery("from " + clazz.getName()).list();
	}

	public List<E> getListByExample(E bean) {
		Example example = getExample(bean);
		return sessionFactory.getCurrentSession().createCriteria(clazz).add(example).list();
	}
	
	protected Example getExample(E bean){
		Example example = Example.create(bean); 
		example.enableLike(MatchMode.ANYWHERE);
		example.ignoreCase();
		example.excludeZeroes();
		return example;
	}


	public List<E> find(String hql) {
		 final List<E> entities = getHibernateTemplate().find(hql);  
	        return entities;
	}
	
	

}
