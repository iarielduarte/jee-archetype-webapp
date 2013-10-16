package ar.com.jericho.service;

import java.util.List;

import ar.com.jericho.model.bean.User;


/**
 * 
 * User Service Interface
 * 
 * @author Ariel Duarte
 * @since 10 Oct 2013
 * @version 1.0.0
 *
 */
public interface IUserService {
	
	public boolean addUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(User user);
	public User getUserById(int id);
	public List<User> getUsers();
	
}
