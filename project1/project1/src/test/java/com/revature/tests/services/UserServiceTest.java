package com.revature.tests.services;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.revature.daos.impl.UserDAOImpl;
import com.revature.models.User;
import com.revature.services.UserService;
import com.revature.services.impl.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	private static final String USERNAME = "test";
	private static final String PASSWORD = "password";
	private static User user = new User();
	@Mock
	private static UserDAOImpl daoMock;
	@InjectMocks
	private static UserService us = new UserServiceImpl();

	@BeforeClass
	public static void setUpBeforeClass() {
		user.setUsername("test");
		user.setPassword("password");
	}
	@Test
	public void loginWithCorrectCredentials() {
		when(daoMock.getByUsername(USERNAME)).thenReturn(user);
		assertNotNull(us.login(USERNAME, PASSWORD));
	}
}