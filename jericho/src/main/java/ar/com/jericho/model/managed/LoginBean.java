package ar.com.jericho.model.managed;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

@ManagedBean(name = "loginBean")
@ViewScoped
@SessionScoped
public class LoginBean {

	private String username;  
    
    private String password;  
      
    public String getUsername() {  
        return username;  
    }  
  
    public void setUsername(String username) {  
        this.username = username;  
    }  
  
    public String getPassword() {  
        return password;  
    }  
  
    public void setPassword(String password) {  
        this.password = password;  
    }  
  
    public void login(ActionEvent actionEvent) {  
        RequestContext context = RequestContext.getCurrentInstance();  
        FacesMessage msg = null;  
        boolean loggedIn = false;  
          
        if(username != null  && username.equals("admin") && password != null  && password.equals("admin")) {  
            loggedIn = true;  
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);  
        } else {  
            loggedIn = false;  
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials");  
        }  
          
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn);  
    }  
}
