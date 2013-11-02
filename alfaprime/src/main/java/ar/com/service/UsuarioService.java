package ar.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.model.bean.Usuario;
import ar.com.model.dao.UsuarioDao;

@Service
public class UsuarioService implements IUsuarioService {

	
	@Autowired
	private UsuarioDao usuarioDao;

	
	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	@Transactional
	public void addUsuario(Usuario usuario) {
		getUsuarioDao().addUsuario(usuario);
		
	}

	@Transactional
	public void updateUsuario(Usuario usuario) {
		getUsuarioDao().updateUsuario(usuario);
		
	}

	@Transactional
	public void deleteUsuario(Usuario usuario) {
		getUsuarioDao().deleteUsuario(usuario);
		
	}

	@Transactional
	public Usuario getUsuarioById(int id) {
		return getUsuarioDao().getUsuarioById(id);
	}

	@Transactional
	public List<Usuario> getUsuarios() {
		return getUsuarioDao().getUsuarios();
	}

	@Transactional
	public Usuario findByUsuario(Usuario usuario) {
		return getUsuarioDao().findByUsuario(usuario);
	}

	@Transactional
	public Usuario login(Usuario usuario) {
		return getUsuarioDao().login(usuario);
	}


	

}
