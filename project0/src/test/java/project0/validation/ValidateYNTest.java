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
public class ValidateYNTest {
	@Parameters
	public static Collection<Object[]> cases() {
		return Arrays.asList(new Object[][] {
			{"x", false}, // alpha character that is not 'y' or 'n'
			{"1", false}, // numeric character
			{".", false}, // non-alphanumeric
			{" ", false}, // whitespace
			{"apple", false}, // string
			{"y", true}, // lower 'y'
			{"Y", true}, // upper 'Y'
			{"n", true}, // lower 'n'
			{"N", true}, // lower 'N'
		});
	}
	
	private final String test;
	private final boolean isValid;
	
	public ValidateYNTest(String test, boolean isValid) {
		this.test = test;
		this.isValid = isValid;
	}
	
	@Test
	public void testValidateYN() {
		try {
			assertEquals(isValid, InputValidation.validateYN(test));
		} catch (InvalidInputException e) { }
	}
}