package com.revature.services.impl;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.services.UserService;

public class UserServiceImpl implements UserService {
	@Override
	public User login(String username, String password) {
		/*
		 * return User object if "username" and "password" combination are valid,
		 * else return null;
		 */
		return null;
	}
	@Override
	public void updateInfo(User user) {
		/*
		 * updates the "user" info;
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