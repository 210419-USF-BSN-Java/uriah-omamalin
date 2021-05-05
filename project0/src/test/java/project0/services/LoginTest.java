package project0.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.shop.exceptions.BusinessException;
import com.shop.models.User;
import com.shop.services.UserService;
import com.shop.services.impl.UserServiceImpl;

public class LoginTest {
	static UserService us;
	static User u;
	
	@BeforeClass
	public static void setUp() {
		us = new UserServiceImpl();
	}
	@Before
	public void beforeEach() {
		System.out.println("-- testing....");
		u = null;
	}
	@After
	public void afterEach() {
		System.out.println("-- test completed.");
		u = null;
	}
	@AfterClass
	public static void tearDown() { }
	@Test
	public void testIncorrectCredentials() {
		try {
			u = us.login(2, "employee");
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		} finally {
			assertNull(u);
		}
	}
	@Test
	public void testCorrectCredentials() {
		try {
			u = us.login(2, "customer");
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		} finally {
			assertNotNull(u);
		}
	}
}