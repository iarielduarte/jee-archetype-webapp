package ar.com.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.model.bean.Rol;
import ar.com.model.dao.RolDao;
import ar.com.model.dao.UsuarioDao;

@Service
public class RolService implements IRolService, Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private RolDao rolDao;
	
	
	public RolDao getRolDao() {
		return rolDao;
	}

	public void setRolDao(RolDao rolDao) {
		this.rolDao = rolDao;
	}

	@Transactional
	public void addRol(Rol rol) {
		getRolDao().addRol(rol);

	}

	@Transactional
	public void updateRol(Rol rol) {
		getRolDao().updateRol(rol);

	}

	@Transactional
	public void deleteRol(Rol rol) {
		getRolDao().deleteRol(rol);

	}

	@Transactional
	public Rol getRolById(int id) {
		return getRolDao().getRolById(id);
	}

	@Transactional
	public List<Rol> getRols() {
		return getRolDao().getRols();
	}


}
