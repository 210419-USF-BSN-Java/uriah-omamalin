package com.revature.services.impl;

import com.revature.daos.UserDAO;
import com.revature.daos.impl.UserDAOImpl;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.services.UserService;

public class UserServiceImpl implements UserService {
	private static UserDAO ud = new UserDAOImpl();
	
	@Override
	public User login(String username, String password) {
		/*
		 * returns corresponding User object if "username" and "password" combination are valid,
		 * else returns null;
		 */
		User testUser = ud.getByUsername(username);
		
		if (testUser.getPassword().equals(password)) { return testUser; }
		else return null;
	}
	@Override
	public void updateInfo(User user) {
		/*
		 * updates the information of the "user"
		 * by storing the new data in the u;
		 */
	}
	@Override
	public void sendEmail(Reimbursement reimb) {
		/*
		 * sends an email to the "reimb.reimbAuthor" about one of their "reimb" being resolved
		 * by a "reimb.reimbResolver";
		 */
	}
}