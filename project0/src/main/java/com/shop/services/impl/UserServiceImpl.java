package com.shop.services.impl;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.shop.daos.CredentialDAO;
import com.shop.daos.CustomerDAO;
import com.shop.daos.EmployeeDAO;
import com.shop.daos.UserDAO;
import com.shop.daos.impl.CredentialDAOImpl;
import com.shop.daos.impl.CustomerDAOImpl;
import com.shop.daos.impl.EmployeeDAOImpl;
import com.shop.daos.impl.UserDAOImpl;
import com.shop.exceptions.BusinessException;
import com.shop.models.Credential;
import com.shop.models.Customer;
import com.shop.models.Employee;
import com.shop.models.Manager;
import com.shop.models.User;
import com.shop.services.UserService;
import com.shop.util.Menu;

public class UserServiceImpl implements UserService {
	CredentialDAO crd = new CredentialDAOImpl();
	UserDAO ud = new UserDAOImpl();
	CustomerDAO cud = new CustomerDAOImpl();
	EmployeeDAO ed = new EmployeeDAOImpl();
	
	@Override
	public User login(int id, String password) throws BusinessException {
		if (bytesToHex(password).equals(crd.read(id).getUserPass())) {
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
	@Override
	public int register(Customer c, String pass) {
		User u = new User();
		u.setUserType(0);
		int id = ud.create(u);
		c.setId(id);
		cud.create(c);
		Credential cr = new Credential(id, bytesToHex(pass));
		crd.create(cr);
		return id;
	}
	private static String bytesToHex(String pass) {
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			Menu.errorln(e.getMessage());
		}
		byte[] encodedHash = digest.digest(pass.getBytes(StandardCharsets.UTF_8));
		
		StringBuilder hexString = new StringBuilder(2 * encodedHash.length);
	    for (int i = 0; i < encodedHash.length; i++) {
	        String hex = Integer.toHexString(0xff & encodedHash[i]);
	        if(hex.length() == 1) {
	            hexString.append('0');
	        }
	        hexString.append(hex);
	    }
	    return hexString.toString();
	}
}