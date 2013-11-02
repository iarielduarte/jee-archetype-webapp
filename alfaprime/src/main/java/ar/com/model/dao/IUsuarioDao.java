package ar.com.model.dao;

import java.util.List;

import ar.com.model.bean.Usuario;

public interface IUsuarioDao {

	public void addUsuario(Usuario usuario);
	public void updateUsuario(Usuario usuario);
	public void deleteUsuario(Usuario usuario);
	public Usuario getUsuarioById(int id);
	public List<Usuario> getUsuarios();
	public Usuario findByUsuario(Usuario usuario);
	public Usuario login(Usuario usuario);
}
