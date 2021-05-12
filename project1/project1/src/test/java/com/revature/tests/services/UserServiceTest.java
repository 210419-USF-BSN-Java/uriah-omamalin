package com.revature.tests.services;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.AdditionalMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.revature.daos.UserDAO;
import com.revature.exceptions.BusinessException;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.services.UserService;
import com.revature.services.impl.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	private static final String USERNAME = "username";
	private static final String PASSWORD = "password";
	private static User user = new User();
	@Mock
	private static UserDAO daoMock;
	@Mock
	private static Reimbursement reimbMock;
	@InjectMocks
	private static UserService us = new UserServiceImpl(daoMock);

	@BeforeClass
	public static void setUpBeforeClass() {
		user.setUsername("username");
		user.setPassword("password");
	}
	
	// login()
	@Test
	public void loginWithCorrectCredentials() throws BusinessException {
		when(daoMock.getByUsername(USERNAME)).thenReturn(user);
		assertNotNull(us.login(USERNAME, PASSWORD));
	}
	@Test(expected = BusinessException.class)
	public void loginWithIncorrectPassword() throws BusinessException {
		when(daoMock.getByUsername(USERNAME)).thenReturn(user);
		us.login(USERNAME, "incorrect password");
	}
	@Test(expected = BusinessException.class)
	public void loginWithIncorrectUsername() throws BusinessException {
		when(daoMock.getByUsername(AdditionalMatchers.not(eq(USERNAME)))).thenReturn(null);
		us.login("incorrect username", PASSWORD);
	}
	@Test(expected = BusinessException.class)
	public void loginWithBothIncorrect() throws BusinessException {
		when(daoMock.getByUsername(AdditionalMatchers.not(eq(USERNAME)))).thenReturn(null);
		us.login("wrong", "also wrong");
	}
	
	// updateInfo()
	@Test
	public void updateInfoTest() {
		doNothing().when(daoMock).update(any(User.class));
		us.updateInfo(new User());
		verify(daoMock, times(1)).update(any(User.class));
	}
	
	// sendEmail()
	@Test
	public void sendEmailTest() {
		when(daoMock.readOne(any(Integer.class))).thenReturn(new User());
		assertNotNull(us.sendEmail(reimbMock));
	}
}