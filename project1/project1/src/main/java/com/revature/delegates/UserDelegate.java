package com.revature.delegates;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.impl.UserDAOImpl;
import com.revature.models.User;
import com.revature.services.UserService;
import com.revature.services.impl.UserServiceImpl;

public class UserDelegate {
	private UserService us = new UserServiceImpl(new UserDAOImpl());
	private static Logger log = Logger.getLogger(UserDelegate.class);

	public void getEmps(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String requestPath = request.getServletPath();
		List<User> li = null;
		if (Character.isDigit(requestPath.charAt(10))) {
			int id = Integer.parseInt(requestPath.substring(10));
			System.out.println("5 : " + id);
			User u = us.getUserById(id);
			response.setStatus(200);
			response.setHeader("empById", new ObjectMapper().writeValueAsString(u));
		}
		switch(requestPath.substring(9)) {
		case "/all" : 
			li = us.getUsersByRole(1);
			response.setStatus(200);
			response.setHeader("allEmp", new ObjectMapper().writeValueAsString(li));
			log.info("all employees viewed");
			break;
		}
	}
	
	public void updateInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String token = request.getHeader("Authorization");
		String param;
		User u = null;
		if(token != null) {
			String[] userInfo = token.split(":");
			u = us.getUserById(Integer.parseInt(userInfo[0]));
		}				
	
		param = request.getParameter("first");
		if (param != null && !param.isEmpty()) {
			u.setFirstName(param);
		}
		param = request.getParameter("last");
		if (param != null && !param.isEmpty()) {
			u.setLastName(param);
		}
		param = request.getParameter("email");
		if (param != null && !param.isEmpty()) {
			u.setEmail(param);
		}
		us.updateInfo(u);
		response.setStatus(200);
		log.info("user info updated");
	}
}