package com.revature.services;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementService { 
	void submit(Reimbursement r);
	List<Reimbursement> getResolvedReimbursements();
	List<Reimbursement> getPendingReimbursements();
}	