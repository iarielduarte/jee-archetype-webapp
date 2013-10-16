package ar.com.jericho.model.managed;

/**
 * @author Ariel Duarte
 * @since 10 Oct 2013
 * @version 1.0.0
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;
import org.primefaces.event.RowEditEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;

import ar.com.jericho.model.bean.User;
import ar.com.jericho.service.IUserService;

@ManagedBean(name = "userMBean")
@RequestScoped
public class UserManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(UserManagedBean.class);
	private static final String SUCCESS = "success";
	private static final String ERROR = "error";
	List<User> users;
	// Spring User Service is injected...
	@ManagedProperty(value = "#{UserService}")
	IUserService userService;
	
	public UserManagedBean(){
		
	}
	
	@PostConstruct
	public void inicializar() {
		users = getUserService().getUsers();
		
	}
	
	List<User> userList;

	private String name;
	private String password;
	private String message;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	public void addUser() {
		try {
			User user = new User();
			user.setName(getName());
			user.setPassword(getPassword());
			
		    if(getUserService().addUser(user))
		    {
		        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success : ",  "The row with the id "+user.getId()+" has been added successfully.");
		        FacesContext.getCurrentInstance().addMessage(null, message);
		        users = new ArrayList<User>();
			    users.addAll(getUserService().getUsers());
		    }else{
		    	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error : ",  "The row with the id "+user.getId()+" has not been added successfully.");
		        FacesContext.getCurrentInstance().addMessage(null, message);
		    }
		} catch (DataAccessException e) {
			e.printStackTrace();
			log.debug(e.getMessage());
		}

	}
	
	public void onEdit(RowEditEvent event) {
		User user = (User) event.getObject();

	    if(getUserService().updateUser((User) event.getObject()))
	    {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success : ",  "The row with the id "+user.getId()+" has been updated successfully.");
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }else{
	    	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error : ",  "The row with the id "+user.getId()+" has not been updated successfully.");
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }
	}
	
	
	
	
	public void onDelete(User user) {
	    if(getUserService().deleteUser(user))
	    {
	    	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success : ",  "The row with the id "+user.getId()+" has been deleted successfully.");
	        FacesContext.getCurrentInstance().addMessage(null, message);
	       
	    }else{
	    	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error : ",  "The row with the id "+user.getId()+" has not been updated successfully.");
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }
	    users = new ArrayList<User>();
	    users.addAll(getUserService().getUsers());
	}
	
	 public void onCancel(RowEditEvent event) {  
	        FacesMessage msg = new FacesMessage("User edit cancelled", ((User) event.getObject()).getName());  
	  
	        FacesContext.getCurrentInstance().addMessage(null, msg);  
	    }  

	/**
	 * Reset Fields
	 * 
	 */
	public void reset() {
		this.setName("");
		this.setPassword("");
	}

	/**
	 * Get User List
	 * @return List - User List
	 */
	public List<User> getUsers() {
			return users;
		
//			userList = new ArrayList<User>();
//			userList.addAll(getUserService().getUsers());
//			return userList;
		}
		

	

	/**
	 * Get User Service
	 * @return IUserService - User Service
	 */
	public IUserService getUserService() {
		return userService;
	}

	/**
	 * Set User Service
	 * @param IUserService User Service
	 */
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	/**
	 * Set User List
	 * @param List User List
	 */
	public void setUsers(List<User> userList) {
		this.userList = userList;
	}

	public String getMessage() {
		StringBuffer strBuff = new StringBuffer();
		strBuff.append("Name : ").append(this.getName());
		strBuff.append(", Password : ").append(this.getPassword());
		this.setMessage(strBuff.toString());
		return this.message;
	}
	

	public String processPage1() {
		return "success1";
	}

	public String processPage2() {
		return "success2";
	}

	public String goHome() {
		return "home";
	}

}
