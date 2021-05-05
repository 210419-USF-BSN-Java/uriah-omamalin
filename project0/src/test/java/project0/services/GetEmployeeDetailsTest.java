package project0.services;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.shop.models.Employee;
import com.shop.models.User;
import com.shop.services.UserService;
import com.shop.services.impl.UserServiceImpl;

public class GetEmployeeDetailsTest {
	static UserService us;
	static Employee e;
	static User u;
	
	@BeforeClass
	public static void setUp() {
		us = new UserServiceImpl();
	}
	@Before
	public void beforeEach() {
		System.out.println("-- testing....");
		u = new User();
		u.setId(5);
		e = us.getEmployeeDetails(u);
	}
	@After
	public void afterEach() {
		System.out.println("-- test completed.");
		u = null;
		e = null;
	}
	@AfterClass
	public static void tearDown() { }
	@Test
	public void testMatchingCustomerId() {
		assertEquals(5, e.getId().intValue());
	}
	@Test
	public void testMatchingFirstName() {
		assertEquals("Virgie", e.getFirstName());
	}
	@Test
	public void testMatchingLastName() {
		assertEquals("Vevers", e.getLastName());
	}
}