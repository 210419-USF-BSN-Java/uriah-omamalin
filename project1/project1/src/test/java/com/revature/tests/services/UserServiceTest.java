package com.revature.tests.services;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.AdditionalMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.revature.daos.UserDAO;
import com.revature.exceptions.BusinessException;
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
	@InjectMocks
	private static UserService us = new UserServiceImpl(daoMock);

	@BeforeClass
	public static void setUpBeforeClass() {
		user.setUsername("username");
		user.setPassword("password");
	}
	
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
}