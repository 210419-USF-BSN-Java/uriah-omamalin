package com.revature.services;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface ReimbursementService { 
	void submit(Reimbursement r);
	List<Reimbursement> getResolvedReimbursementsByAuthor(User u);
	List<Reimbursement> getPendingReimbursementsByAuthor(User u);
	List<Reimbursement> getAllReimbursementsByAuthor(User u);
	List<Reimbursement> getAllReimbursements();
	List<Reimbursement> getAllPendingReimbursements();
	List<Reimbursement> getAllResolvedReimbursements();
	void updateReimb(Reimbursement r);
	Reimbursement getReimbursement(int id);
}	