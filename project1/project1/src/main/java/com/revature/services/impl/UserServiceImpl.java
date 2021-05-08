package com.revature.services.impl;

import com.revature.daos.UserDAO;
import com.revature.exceptions.BusinessException;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.services.UserService;

public class UserServiceImpl implements UserService {
	private UserDAO ud;

	public UserServiceImpl(UserDAO ud) {
		super();
		this.ud = ud;
	}
	
	@Override
	public User login(String username, String password) throws BusinessException {
		/*
		 * returns corresponding User object if "username" and "password" combination are valid,
		 * else throws a BusinessException;
		 */
		User user = ud.getByUsername(username);
		
		if (user != null && user.getPassword().equals(password)) { return user; }
		else throw new BusinessException("invalid login");
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