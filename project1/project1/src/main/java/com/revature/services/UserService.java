package com.revature.services;

import java.util.List;
import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface UserService {
	User login(String username, String password);
	void updateInfo(User user);
	String sendEmail(Reimbursement reimb);
	List<User> getUsers();
	User getUserById(int id);
	List<User> getUsersByRole(int roleId);
}