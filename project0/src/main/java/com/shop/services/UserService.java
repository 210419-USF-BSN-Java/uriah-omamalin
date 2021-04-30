package com.shop.services;

import com.shop.exceptions.BusinessException;
import com.shop.models.Customer;
import com.shop.models.User;

public interface UserService {
	User login(int id, String password) throws BusinessException;
	Customer getCustomerDetails(User user);
}