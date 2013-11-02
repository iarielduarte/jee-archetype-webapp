package ar.com.model.dao;

/**
 * @author Ariel Duarte
 * @since 23-Oct-2013
 * @version 1.0.0
 */

import java.io.Serializable;
import java.util.List;


public interface IHibernateDao<E, ID extends Serializable> {
    void add(E entity);
    void update(E entity);
    void delete(E entity);
    E getByID(ID id);
    List<E> getList();
    List<E> getListByExample(E entity);
    List<E> find(String hql);  
}
