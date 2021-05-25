package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.delegates.AuthDelegate;
import com.revature.delegates.ReimbDelegate;
import com.revature.delegates.UserDelegate;

public class RequestHelper {
	private AuthDelegate authDelegate = new AuthDelegate();
	private UserDelegate userDelegate = new UserDelegate();
	private ReimbDelegate reimbDelegate = new ReimbDelegate();
	
	public void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		System.out.println("1 : " + path);
		if(path.startsWith("/api/")) {
			if(!authDelegate.isAuthorized(request)) {
				response.sendError(401);
				return;
			}
			String record = path.substring(5);
			if (record.startsWith("emps")) {
				userDelegate.getEmps(request, response);
			}
			if (record.startsWith("reimbs")) {
				reimbDelegate.getReimbs(request, response);
			}
		}
	}
	
	public void processPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String path = request.getServletPath();
		System.out.println("3 : " + path);
		if (path.startsWith("/api/reimbs")) {
			reimbDelegate.process(request, response);
		} else {
			switch(path) {
			case "/update" :
				userDelegate.updateInfo(request, response);
				break;
			case "/submit" :
				reimbDelegate.addReimb(request, response);
				break;
			case "/static/login.html" :
				authDelegate.authenticate(request, response);
				break;
			default:
				response.sendError(405);
			}
		}
	}
}