package com.shop.services.impl;

import com.shop.daos.CredentialDAO;
import com.shop.daos.CustomerDAO;
import com.shop.daos.EmployeeDAO;
import com.shop.daos.UserDAO;
import com.shop.daos.impl.CredentialDAOImpl;
import com.shop.daos.impl.CustomerDAOImpl;
import com.shop.daos.impl.EmployeeDAOImpl;
import com.shop.daos.impl.UserDAOImpl;
import com.shop.exceptions.BusinessException;
import com.shop.models.Customer;
import com.shop.models.Employee;
import com.shop.models.Manager;
import com.shop.models.User;
import com.shop.services.UserService;

public class UserServiceImpl implements UserService {
	CredentialDAO crd = new CredentialDAOImpl();
	UserDAO ud = new UserDAOImpl();
	CustomerDAO cud = new CustomerDAOImpl();
	EmployeeDAO ed = new EmployeeDAOImpl();
	
	@Override
	public User login(int id, String password) throws BusinessException {
		if (password.equals(crd.read(id).getUserPass())) {
			return ud.read(id);
		} else throw new BusinessException("invalid id and password combination");
	}
	@Override
	public Customer getCustomerDetails(User user) {
		return cud.read(user.getId());
	}
	@Override
	public Employee getEmployeeDetails(User user) {
		return ed.read(user.getId());
	}
	@Override
	public Manager getManagerDetails(User user) {
		// TODO Auto-generated method stub
		return null;
	}
}