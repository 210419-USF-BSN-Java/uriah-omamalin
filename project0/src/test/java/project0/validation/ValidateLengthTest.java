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
public class ValidateLengthTest {
	@Parameters
	public static Collection<Object[]> cases() {
		return Arrays.asList(new Object[][] {
			{"123456789012345678901", false}, // 21 characters, max 20
			{"12345678901234567890", true}, // 20 characters, max 20
			{"1234567890", true}, // 10 characters, max 20
		});
	}
	
	private final String test;
	private final boolean isValid;
	
	public ValidateLengthTest(String test, boolean isValid) {
		this.test = test;
		this.isValid = isValid;
	}
	
	@Test
	public void testValidateLength() {
		try {
			assertEquals(isValid, InputValidation.validateLength(test));
		} catch (InvalidInputException e) { }
	}
}