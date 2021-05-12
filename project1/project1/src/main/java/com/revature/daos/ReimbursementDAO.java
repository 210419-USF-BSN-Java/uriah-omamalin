package com.revature.daos;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDAO extends GenericDAO<Reimbursement, Integer> {
	List<Reimbursement> getResolvedReimbursements();
	List<Reimbursement> getPendingReimbursements();
}