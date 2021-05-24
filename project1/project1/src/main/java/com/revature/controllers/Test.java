package com.revature.controllers;

import java.util.List;

import com.revature.daos.impl.ReimbursementDAOImpl;
import com.revature.daos.impl.UserDAOImpl;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.services.ReimbursementService;
import com.revature.services.UserService;
import com.revature.services.impl.ReimbursementServiceImpl;
import com.revature.services.impl.UserServiceImpl;

public class Test {
	public static void main(String[] args) {
		UserService us = new UserServiceImpl(new UserDAOImpl());
		ReimbursementService rs = new ReimbursementServiceImpl(new ReimbursementDAOImpl());
		
		User u = us.login("nselway1", "3wyVd44U5Io");
		System.out.println(u);
		
		u = new User();
		u.setUsersId(6);
		List<Reimbursement> li = rs.getAllReimbursementsByAuthor(u);
		for (Reimbursement r : li) {
			System.out.println(r.getReimbId() + " " + r.getReimbAuthor());
		}
	}
}