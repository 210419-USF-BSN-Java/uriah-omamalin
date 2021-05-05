package project0.services;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.shop.models.Item;
import com.shop.services.ItemService;
import com.shop.services.impl.ItemServiceImpl;

public class GetItemDetailsTest {
	static ItemService is;
	static Item i;
	
	@BeforeClass
	public static void setUp() {
		is = new ItemServiceImpl();
		i = is.getItemDetails(10);
	}
	@Before
	public void beforeEach() {
		System.out.println("-- testing....");
	}
	@After
	public void afterEach() {
		System.out.println("-- test completed.");
	}
	@AfterClass
	public static void tearDown() { }
	@Test
	public void testMatchingItemId() {
		assertEquals(10, i.getId().intValue());
	}
	@Test
	public void testMatchingItemName() {
		assertEquals("Body", i.getItemName());
	}
	@Test
	public void testMatchingPrice() {
		assertEquals(BigDecimal.valueOf(93.91), i.getPrice());
	}
}