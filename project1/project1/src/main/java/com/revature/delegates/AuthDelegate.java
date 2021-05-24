package com.revature.delegates;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.daos.impl.UserDAOImpl;
import com.revature.models.User;
import com.revature.services.UserService;
import com.revature.services.impl.UserServiceImpl;

public class AuthDelegate {
	private UserService us = new UserServiceImpl(new UserDAOImpl());
	public void authenticate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User u;
		u = us.login(username, password);
		if (u != null) {
			String token = u.getUsersId() + ":" + u.getRoleId();
			response.setStatus(200);
			response.setHeader("Authorization", token);
		} else {
			response.sendError(401);
		}
	}
	public boolean isAuthorized(HttpServletRequest request) {
		String authToken = request.getHeader("Authorization");
		if(authToken != null) {
			String[] tokenArr = authToken.split(":");
			if (tokenArr.length == 2) {
				String idStr = tokenArr[0];
				String userRoleStr =  tokenArr[1];
				User u = us.getUserById(Integer.parseInt(idStr));
				if(u != null && u.getRoleId() == Integer.parseInt(userRoleStr)) {
					return true;
				}
			}
		}
		return false;
	}
}