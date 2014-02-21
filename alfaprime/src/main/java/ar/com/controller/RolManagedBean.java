package ar.com.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import ar.com.model.bean.Rol;
import ar.com.model.bean.Usuario;
import ar.com.service.IRolService;
import ar.com.service.IUsuarioService;
import ar.com.service.RolService;
import ar.com.service.UsuarioService;

@ManagedBean(name = "rolMBean")
@ViewScoped
@SessionScoped
public class RolManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{RolService}")
	private IRolService rolService;
	private String nombre;
	private List<Rol> roles;
	
	
	
	@PostConstruct
	public void inicializar() {
    	roles = getRolService().getRols();
		
	}
	
	/*TODO: View...Actions*/
	public void add(){
		Rol rol = new Rol();
		rol.setNombre(getNombre());
		getRolService().addRol(rol);
		
	}
	
	private List<SelectItem> selectOneItemRol;
	
	
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

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> rols) {
		this.roles = rols;
	}

	public List<SelectItem> getSelectOneItemRol() {
		selectOneItemRol = new ArrayList<SelectItem>();
		List<Rol> roles = getRolService().getRols();
		for (Rol rol : roles) {
			SelectItem selectItem = new SelectItem(rol.getId(), rol.getNombre());
			selectOneItemRol.add(selectItem);
		}
		return selectOneItemRol;
	}

	


}
