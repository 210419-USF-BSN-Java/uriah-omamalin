package com.revature.services;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface UserService {
	User login(String username, String password);
	void updateInfo(User user);
	void sendEmail(Reimbursement reimb);
	// ....
}