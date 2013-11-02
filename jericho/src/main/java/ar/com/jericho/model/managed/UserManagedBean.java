package ar.com.jericho.model.managed;

/**
 * @author Ariel Duarte
 * @since 10 Oct 2013
 * @version 1.0.0
 */
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.primefaces.event.RowEditEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;

import ar.com.jericho.model.bean.User;
import ar.com.jericho.service.IUserService;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;

import com.itextpdf.text.FontFactory;

import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Paragraph;
import org.primefaces.context.RequestContext;  

@ManagedBean(name = "loginBean")
@ViewScoped
@SessionScoped
public class UserManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(UserManagedBean.class);
	private static final String SUCCESS = "success";
	private static final String ERROR = "error";
	
	// Spring User Service is injected...
	@ManagedProperty(value = "#{UserService}")
	IUserService userService;
	
	public UserManagedBean(){
		
	}
	
	@PostConstruct
	public void inicializar() {
		users = getUserService().getUsers();
		
	}
	
	

	private String name;
	private String password;
	private String message;
	
	List<User> users;
	List<User> userList;
	List<User> filteredUsers;
	private User selectedUser;
	
	public User getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}
	
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
			    reset();
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
	
	public List<User> getFilteredUsers() {  
        return filteredUsers;  
    }  
  
    public void setFilteredUsers(List<User> filteredUsers) {  
        this.filteredUsers = filteredUsers;  
    }  
    
    public void imprimir() {
        
        Document document = new Document(PageSize.LETTER);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
              PdfWriter.getInstance(document, baos);
             //METADATA
              List<User> usersList = new ArrayList<User>();
              usersList.addAll(getUserService().getUsers());
      	    
      	    
//              AlumnoDao alumnodaos = new AlumnoDao();
//              List<Alumno> alList = alumnodaos.buscarTodos();
             document.open();
            
             document.add(new Paragraph(" USUARIOS REGISTRADOS \n"));
            
             DateFormat formatter= new SimpleDateFormat("dd/MM/yy '-' hh:mm:ss:");
              Date currentDate = new Date();
              String date = formatter.format(currentDate);
             document.add(new Paragraph("Fecha Generado: "+date)); 
             document.add(new Paragraph("\n"));
            
             PdfPTable table = new PdfPTable(3);
            
             table.setTotalWidth(new float[]{ 50, 110, 170 });
         table.setLockedWidth(true);
            
        
          PdfPCell cell = new PdfPCell(new Paragraph("Listado de Usuarios" ,
                  FontFactory.getFont("arial",   // fuente
                    8,                            // tamaño
                Font.BOLD,                   // estilo
                          BaseColor.MAGENTA)));
             cell.setHorizontalAlignment(Element.ALIGN_CENTER);
             cell.setBackgroundColor(BaseColor.GRAY);
             cell.setColspan(3);
             table.addCell(cell);

             cell = new PdfPCell(new Paragraph ("ID", FontFactory.getFont("arial",8,Font.BOLD,BaseColor.GRAY )));
              
           
             table.addCell("Id");
             table.addCell("Nombre");
             table.addCell("Password");
            
            
             for (int i = 0; i < usersList.size(); i++) {
                   User id = usersList.get(i);
                   table.addCell(id.getId().toString());
                   cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                   table.addCell(id.getName());
                   table.addCell(id.getPassword());
                   
             }
             document.add(table);
       } catch (Exception ex) {
             System.out.println("Error " + ex.getMessage());
       }
       document.close();
       FacesContext context = FacesContext.getCurrentInstance();
       Object response = context.getExternalContext().getResponse();
       if (response instanceof HttpServletResponse) {
             HttpServletResponse hsr = (HttpServletResponse) response;
             hsr.setContentType("application/pdf");
             hsr.setHeader("Content-disposition", "attachment");
             hsr.setContentLength(baos.size());
             try {
                   ServletOutputStream out = hsr.getOutputStream();
                   baos.writeTo(out);
                   out.flush();
             } catch (IOException ex) {
                   System.out.println("Error:  " + ex.getMessage());
             }
             context.responseComplete();
       }
  }
  public void reset2() { 
         RequestContext.getCurrentInstance().reset("formEditar:panel"); 
     } 
  
    
}
