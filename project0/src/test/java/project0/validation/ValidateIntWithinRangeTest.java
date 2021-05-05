package project0.validation;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.shop.exceptions.InvalidInputException;
import com.shop.util.InputValidation;

@RunWith(Parameterized.class)
public class ValidateIntWithinRangeTest {
	@Parameters
	public static Collection<Object[]> cases() {
		return Arrays.asList(new Object[][] {
			{"3", 4, 6, false}, // barely below
			{"1", 5, 7, false}, // moderately below
			{"8", 2, 7, false}, // barely above
			{"12", 4, 6, false}, // moderately above
			{"+12", 10, 14, false}, // in range but invalid format
			{"apple", 4, 6, false}, // invalid string input
			{"2", 2, 98, true}, // lower edge of range
			{"24", 13, 38, true}, // middle of range
			{"59", 33, 59, true}, // upper edge of range
		});
	}
	
	private final String test;
	private final int lb, ub;
	private final boolean isValid;
	
	public ValidateIntWithinRangeTest(String test, int lb, int ub, boolean isValid) {
		this.test = test;
		this.lb = lb;
		this.ub = ub;
		this.isValid = isValid;
	}
	
	@Test
	public void testValidateIntWithinRange() {
		try {
			assertEquals(isValid, InputValidation.validateIntWithinRange(test, lb, ub));
		} catch (InvalidInputException e) { }
	}
}