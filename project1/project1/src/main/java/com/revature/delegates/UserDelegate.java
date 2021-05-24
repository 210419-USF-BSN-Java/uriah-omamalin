package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.impl.UserDAOImpl;
import com.revature.models.User;
import com.revature.services.UserService;
import com.revature.services.impl.ReimbursementServiceImpl;
import com.revature.services.impl.UserServiceImpl;

public class UserDelegate {
	private UserService us = new UserServiceImpl(new UserDAOImpl());
	private static Logger log = Logger.getLogger(UserDelegate.class);

	public void getEmps(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String requestPath = request.getServletPath();
		List<User> li = null;
		switch(requestPath.substring(9)) {
		case "/all" : 
			li = us.getUsersByRole(1);
			response.setStatus(200);
			response.setHeader("allEmp", new ObjectMapper().writeValueAsString(li));
			break;
		}
		log.info("all employees viewed");
	}
}