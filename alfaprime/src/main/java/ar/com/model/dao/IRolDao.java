package ar.com.model.dao;

import java.util.List;

import ar.com.model.bean.Rol;

public interface IRolDao {

	public void addRol(Rol rol);
	public void updateRol(Rol rol);
	public void deleteRol(Rol rol);
	public Rol getRolById(int id);
	public List<Rol> getRols();
	
}
