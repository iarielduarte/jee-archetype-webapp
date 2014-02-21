package ar.com.controller;

/**
 * @author Ariel Duarte
 * 
 */
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import ar.com.util.Util;

@ManagedBean(name = "appMBean")
@ApplicationScoped
public class AppManagedBean {

	public AppManagedBean() {
	
	}
	
	
	public String getBaseUrl(){
		return Util.baseurl();
	}
	

	public String getBasePath(){
		return Util.basepath();
	}
}
