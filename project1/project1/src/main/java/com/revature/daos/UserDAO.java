package com.revature.daos;

import java.util.List;

import com.revature.models.User;

public interface UserDAO extends GenericDAO<User, Integer> {
	User getByUsername(String username);
	List<User> getUsersByRole(int roleId);
}