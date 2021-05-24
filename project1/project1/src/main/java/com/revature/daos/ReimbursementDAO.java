package com.revature.daos;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDAO extends GenericDAO<Reimbursement, Integer> {
	List<Reimbursement> getResolvedReimbursementsByAuthorId(int authorId);
	List<Reimbursement> getPendingReimbursementsByAuthorId(int authorId);
	List<Reimbursement> getAllReimbursementsByAuthorId(int authorId);
	List<Reimbursement> getAllPendingReimbursements();
	List<Reimbursement> getAllResolvedReimbursements();
}