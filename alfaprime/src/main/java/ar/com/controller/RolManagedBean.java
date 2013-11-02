package ar.com.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import ar.com.model.bean.Rol;
import ar.com.model.bean.Usuario;
import ar.com.service.IRolService;
import ar.com.service.IUsuarioService;
import ar.com.service.UsuarioService;

@ManagedBean(name = "rolMBean")
@RequestScoped
public class RolManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{RolService}")
	private IRolService rolService;
	private String nombre;
	private List<Rol> rols;
	
	@ManagedProperty(value = "#{UsuarioService}")
	IUsuarioService usuService;
	
	/*TODO: View...Actions*/
	public void add(){
		Rol rol = new Rol();
		rol.setNombre(getNombre());
		getRolService().addRol(rol);
		
		Usuario usu = new Usuario();
		usu.setNombre("Ariel");
		usu.setRol(getRolService().getRolById(1));
		usu.setClave("123");
		usu.setEmail("@");
		getUsuService().addUsuario(usu);
		
	}
	
	
	
	
	/*TODO: Getters...and...Setters*/
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String name) {
		this.nombre = name;
	}

	public IRolService getRolService() {
		return rolService;
	}

	public void setRolService(IRolService rolService) {
		this.rolService = rolService;
	}

	public List<Rol> getRols() {
		return rols;
	}

	public void setRols(List<Rol> rols) {
		this.rols = rols;
	}




	public IUsuarioService getUsuService() {
		return usuService;
	}




	public void setUsuService(IUsuarioService usuService) {
		this.usuService = usuService;
	}
	
	
	

}
