package ar.com.service;

import java.util.List;

import ar.com.model.bean.Usuario;


public interface IUsuarioService {

	public boolean addUsuario(Usuario usuario);
	public boolean updateUsuario(Usuario usuario);
	public boolean deleteUsuario(Usuario usuario);
	public Usuario getUsuarioById(int id);
	public List<Usuario> getUsuarios();
	public Usuario findByUsuario(Usuario usuario);
	public Usuario login(Usuario usuario);
	
}
