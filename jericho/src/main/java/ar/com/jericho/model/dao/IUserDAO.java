package ar.com.jericho.model.dao;

import java.util.List;

import ar.com.jericho.model.bean.User;


/**
 * 
 * User DAO Interface
 * 
 * @author Ariel Duarte
 * @since 10 Oct 2013
 * @version 1.0.0
 *
 */
public interface IUserDAO {

	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(User user);
	public User getUserById(int id);
	public List<User> getUsers();
}
