package com.revature.services.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.daos.ReimbursementDAO;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.services.ReimbursementService;

public class ReimbursementServiceImpl implements ReimbursementService {
	private ReimbursementDAO rd;
	private static Logger log = Logger.getLogger(ReimbursementServiceImpl.class);
	
	public ReimbursementServiceImpl(ReimbursementDAO rd) {
		super();
		this.rd = rd;
	}

	@Override
	public void submit(Reimbursement r) {
		/*
		 * writes the provided reimbursement "r" to the database;
		 */
		log.info("new reimbursement submitted by user#" + r.getReimbAuthor() + " for review");
		rd.create(r);
	}
	@Override
	public List<Reimbursement> getResolvedReimbursementsByAuthor(User u) {
		/*
		 * returns a list of all reimbursements submitted by "u" that have been approved or denied;
		 */
		log.info(u.getFullName() + " viewed their resolved reimbursements");
		return rd.getResolvedReimbursementsByAuthorId(u.getUsersId());
	}
	@Override
	public List<Reimbursement> getPendingReimbursementsByAuthor(User u) {
		/*
		 * returns a list of all pending reimbursements submitted by "u";
		 */
		log.info(u.getFullName() + " viewed their pending reimbursements");
		return rd.getPendingReimbursementsByAuthorId(u.getUsersId());
	}
	@Override
	public List<Reimbursement> getAllReimbursementsByAuthor(User u) {
		log.info(u.getFullName() + " viewed all their reimbursements");
		return rd.getAllReimbursementsByAuthorId(u.getUsersId());
	}
	@Override
	public void updateReimb(Reimbursement r, User u) {
		r.setReimbResolver(u.getUsersId());
		r.setReimbResolved(new Date());
		rd.update(r);
	}
	@Override
	public List<Reimbursement> getAllReimbursements() {
		return rd.readAll();
	}
	@Override
	public List<Reimbursement> getAllPendingReimbursements() {
		return rd.getAllPendingReimbursements();
	}
	@Override
	public List<Reimbursement> getAllResolvedReimbursements() {
		return rd.getAllResolvedReimbursements();
	} 
}