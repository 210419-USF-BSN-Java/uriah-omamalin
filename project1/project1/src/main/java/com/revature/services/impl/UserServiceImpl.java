package com.revature.services.impl;

import com.revature.daos.UserDAO;
import com.revature.exceptions.BusinessException;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
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
		 * by storing the new data in the User object;
		 */
		ud.update(user);
	}
	@Override
	public String sendEmail(Reimbursement reimb) {
		/*
		 * returns a String representation of an email to the "reimb.reimbAuthor" 
		 * about one of their "reimb" being resolved
		 * by a "reimb.reimbResolver";
		 */
		String author = ud.readOne(reimb.getReimbAuthor()).getFirstName() + " " + ud.readOne(reimb.getReimbAuthor()).getLastName();
		String resolver = ud.readOne(reimb.getReimbResolver()).getFirstName() + " " + ud.readOne(reimb.getReimbResolver()).getLastName();
		String reimbId = reimb.getReimbId() + "";
		String reimbStatus = ReimbursementStatus.values()[reimb.getReimbStatusId() - 1] + "";
		
		return "an email has been sent to " + author + " about reimbursement #" + reimbId + " being " + reimbStatus.toLowerCase() + " by " + resolver + ".";
	}
}