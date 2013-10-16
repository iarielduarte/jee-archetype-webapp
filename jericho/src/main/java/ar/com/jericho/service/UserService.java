package ar.com.jericho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.jericho.model.bean.User;
import ar.com.jericho.model.dao.IUserDAO;
import ar.com.jericho.model.dao.UserDAO;

/**
 * 
 * User Service
 * 
 * @author Ariel Duarte
 * @since 10 Oct 2013
 * @version 1.0.0
 * 
 */

@Transactional(readOnly = true)
public class UserService implements IUserService {

	// UserDAO is injected...
	IUserDAO userDAO;

	/**
	 * Add User
	 * 
	 */
	@Transactional(readOnly = false)
	public boolean addUser(User user) {
		boolean success = false;
		try {
			getUserDAO().addUser(user);
			success = true;
		} catch (Exception e) {
			// log it and swallow exception
			// calling code has to be sure to check on success flag;
			// otherwise it has no idea something went terribly wrong
		}
		return success;

	}

	/**
	 * Delete User
	 * 
	 */
	@Transactional(readOnly = false)
	public boolean deleteUser(User user) {
		boolean success = false;
		try {
			getUserDAO().deleteUser(user);
			success = true;
		} catch (Exception e) {
			// log it and swallow exception
			// calling code has to be sure to check on success flag;
			// otherwise it has no idea something went terribly wrong
		}
		return success;

	}

	/**
	 * Update User
	 * 
	 */
	@Transactional(readOnly = false)
	public boolean updateUser(User user) {
		boolean success = false;
		try {
			getUserDAO().updateUser(user);
			success = true;
		} catch (Exception e) {
			// log it and swallow exception
			// calling code has to be sure to check on success flag;
			// otherwise it has no idea something went terribly wrong
		}
		return success;

	}

	/**
	 * Get User
	 * 
	 */
	public User getUserById(int id) {
		return getUserDAO().getUserById(id);
	}

	/**
	 * Get User List
	 * 
	 */
	public List<User> getUsers() {
		return getUserDAO().getUsers();
	}

	/**
	 * Get User DAO
	 * 
	 */
	public IUserDAO getUserDAO() {
		return userDAO;
	}

	/**
	 * Set User DAO
	 * 
	 */
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
