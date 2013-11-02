package ar.com.service;

import java.util.List;

import ar.com.model.bean.Rol;


/**
 * 
 * User Service Interface
 * 
 * @author Ariel Duarte
 * @since 10 Oct 2013
 * @version 1.0.0
 *
 */
public interface IRolService {
	
	public void addRol(Rol rol);
	public void updateRol(Rol rol);
	public void deleteRol(Rol rol);
	public Rol getRolById(int id);
	public List<Rol> getRols();
	
}
