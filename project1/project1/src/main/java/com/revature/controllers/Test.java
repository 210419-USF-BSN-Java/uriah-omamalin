package com.revature.controllers;

import com.revature.daos.ReimbursementDAO;
import com.revature.daos.UserDAO;
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
		ReimbursementDAO rd = new ReimbursementDAOImpl();
		UserDAO ud = new UserDAOImpl();
		ReimbursementService rs = new ReimbursementServiceImpl(rd);
		UserService us = new UserServiceImpl(ud);	
		byte[] bytes = new byte[1];
		Reimbursement test = new Reimbursement();
		
//		for (Reimbursement r : rs.getResolvedReimbursements()) {
//			System.out.println(us.sendEmail(r));
//		}
	}
}