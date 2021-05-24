package com.revature.services.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.daos.UserDAO;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.User;
import com.revature.services.UserService;

public class UserServiceImpl implements UserService {
	private UserDAO ud;
	private static Logger log = Logger.getLogger(UserServiceImpl.class);
	
	public UserServiceImpl(UserDAO ud) {
		super();
		this.ud = ud;
	}
	
	@Override
	public User login(String username, String password) {
		User user = ud.getByUsername(username);
		if (password.equals(user.getPassword())) return user;
		else return null;
	}
	@Override
	public void updateInfo(User user) {
		/*
		 * updates the information of the "user"
		 * by storing the new data in the User object;
		 */
		log.info(user.getFullName() + " updated their information");
		ud.update(user);
	}
	@Override
	public String sendEmail(Reimbursement reimb) {
		/*
		 * returns a String representation of an email to the "reimb.reimbAuthor" 
		 * about one of their "reimb" being resolved
		 * by a "reimb.reimbResolver";
		 */
		String author = ud.readOne(reimb.getReimbAuthor()).getFullName();
		String resolver = ud.readOne(reimb.getReimbResolver()).getFullName();
		String reimbId = reimb.getReimbId() + "";
		String reimbStatus = ReimbursementStatus.values()[reimb.getReimbStatusId() - 1] + "";
		
		log.info("an email was sent to " + author);
		return "an email has been sent to " + author + " about reimbursement#" + reimbId + " being " + reimbStatus.toLowerCase() + " by " + resolver + ".";
	}
	@Override
	public List<User> getUsers() {
		/*
		 * returns a list of all User objects;
		 */
		return ud.readAll();
	}
	@Override
	public User getUserById(int id) {
		/*
		 * returns a User with matching id;
		 */
		return ud.readOne(id);
	}

	@Override
	public List<User> getUsersByRole(int roleId) {
		return ud.getUsersByRole(roleId);
	}
}