package project0.services;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.shop.models.Customer;
import com.shop.models.User;
import com.shop.services.UserService;
import com.shop.services.impl.UserServiceImpl;

public class GetCustomerDetailsTest {
	static UserService us;
	static Customer c;
	static User u;
	
	@BeforeClass
	public static void setUp() {
		us = new UserServiceImpl();
	}
	@Before
	public void beforeEach() {
		System.out.println("-- testing....");
		u = new User();
		u.setId(2);
		c = us.getCustomerDetails(u);
	}
	@After
	public void afterEach() {
		System.out.println("-- test completed.");
		u = null;
		c = null;
	}
	@AfterClass
	public static void tearDown() { }
	@Test
	public void testMatchingCustomerId() {
		assertEquals(2, c.getId().intValue());
	}
	@Test
	public void testMatchingFirstName() {
		assertEquals("Clair", c.getFirstName());
	}
	@Test
	public void testMatchingLastName() {
		assertEquals("McGuiness", c.getLastName());
	}
}