package com.revature.delegates;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.impl.ReimbursementDAOImpl;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.services.ReimbursementService;
import com.revature.services.impl.ReimbursementServiceImpl;

public class ReimbDelegate {
	private ReimbursementService rs = new ReimbursementServiceImpl(new ReimbursementDAOImpl());
	private static Logger log = Logger.getLogger(ReimbDelegate.class);

	public void getReimbs(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String requestPath = request.getServletPath();
		if (requestPath.startsWith("/api/reimbs/author/")) {
			String authorStr = requestPath.replace("/api/reimbs/author/", "");
			System.out.println("2 : " + authorStr);
			User u = new User();
			u.setUsersId(Integer.parseInt(authorStr));
			List<Reimbursement> li = rs.getAllReimbursementsByAuthor(u);
			response.setStatus(200);
			response.setHeader("authorList", new ObjectMapper().writeValueAsString(li));
		}
		System.out.println("4 : " + requestPath.substring(11));
		List<Reimbursement> li = null;
		
		switch (requestPath.substring(11)) {
		case "/all" : 
			li = rs.getAllReimbursements();
			response.setStatus(200);
			response.setHeader("allReimb", new ObjectMapper().writeValueAsString(li));
			log.info("all reimbursmenets viewed");
			break;
		case "/pending" :
			li = rs.getAllPendingReimbursements();
			response.setStatus(200);
			response.setHeader("allPendingReimb", new ObjectMapper().writeValueAsString(li));
			log.info("all pending reimbursements viewed");
			break;
		case "/resolved" :
			li = rs.getAllResolvedReimbursements();
			response.setStatus(200);
			response.setHeader("allResolvedReimb", new ObjectMapper().writeValueAsString(li));
			log.info("all resolved reimbursmenets viewed");
		}
	}
		
	public void addReimb(HttpServletRequest request, HttpServletResponse response) throws IOException {
			Reimbursement r = new Reimbursement();
			
			r.setReimbAmount(BigDecimal.valueOf(Double.parseDouble(request.getParameter("amount"))));
			r.setReimbDescription(request.getParameter("description"));
			
			String token = request.getHeader("Authorization");
			if(token != null) {
				String[] userInfo = token.split(":");
				r.setReimbAuthor(Integer.parseInt(userInfo[0]));
			}
			
			switch (request.getParameter("type")) {
			case "lodging":
				r.setReimbTypeId(1);
				break;
			case "travel":
				r.setReimbTypeId(2);
				break;
			case "food":
				r.setReimbTypeId(3);
				break;
			case "other":
				r.setReimbTypeId(4);
				break;
			}
			
			r.setReimbSubmitted(new Date());
			response.setStatus(200);
			rs.submit(r);
			log.info("reimbursement submitted");
	}
	
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("6 : test");
		String token = request.getHeader("Authorization");
		Reimbursement r = rs.getReimbursement(Integer.parseInt(request.getParameter("id")));;
		r.setReimbStatusId(Integer.parseInt(request.getParameter("status")));
		if(token != null) {
			r.setReimbResolver(Integer.parseInt(token.split(":")[0]));
		}
		System.out.println(r.toString());
		rs.updateReimb(r);
		System.out.println(r.toString());
		response.setStatus(200);
		log.info("reimbursement processed");
	}
}