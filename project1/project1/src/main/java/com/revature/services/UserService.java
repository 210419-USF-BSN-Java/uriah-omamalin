package com.revature.services;

import com.revature.exceptions.BusinessException;
import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface UserService {
	User login(String username, String password) throws BusinessException;
	void updateInfo(User user);
	String sendEmail(Reimbursement reimb);
}