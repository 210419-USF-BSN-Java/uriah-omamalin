package com.shop.services;

import com.shop.exceptions.BusinessException;
import com.shop.models.Customer;
import com.shop.models.Employee;
import com.shop.models.Manager;
import com.shop.models.User;

public interface UserService {
	User login(int id, String password) throws BusinessException;
	Customer getCustomerDetails(User user);
	Employee getEmployeeDetails(User user);
	Manager getManagerDetails(User user);
	int register(Customer c, String pass);
}