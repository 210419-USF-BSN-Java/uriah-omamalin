package com.revature.services.impl;

import java.util.List;

import com.revature.daos.ReimbursementDAO;
import com.revature.models.Reimbursement;
import com.revature.services.ReimbursementService;

public class ReimbursementServiceImpl implements ReimbursementService {
	private ReimbursementDAO rd;
	
	public ReimbursementServiceImpl(ReimbursementDAO rd) {
		super();
		this.rd = rd;
	}

	@Override
	public void submit(Reimbursement r) {
		/*
		 * writes the provided reimbursement "r" to the database;
		 */
		rd.create(r);
	}
	@Override
	public List<Reimbursement> getResolvedReimbursements() {
		/*
		 * returns a list of all reimbursements that have been approved or denied;
		 */
		return rd.getResolvedReimbursements();
	}
	@Override
	public List<Reimbursement> getPendingReimbursements() {
		/*
		 * returns a list of all reimbursements that are still pending;
		 */
		return rd.getPendingReimbursements();
	} 
}