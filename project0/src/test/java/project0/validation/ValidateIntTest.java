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
public class ValidateIntTest {
	@Parameters
	public static Collection<Object[]> cases() {
		return Arrays.asList(new Object[][] {
			{"-3", false}, // negative number not allowed
			{"+3", false}, // extraneous symbols
			{"3.2", false}, // no decimals
			{"03", false}, // invalid format
			{"3", true}, // small int
			{"26", true}, // medium int
			{"2568", true}, // big int
		});
	}
	
	private final String test;
	private final boolean isValid;
	
	public ValidateIntTest(String test, boolean isValid) {
		this.test = test;
		this.isValid = isValid;
	}
	
	@Test
	public void testValidateInt() {
		try {
			assertEquals(isValid, InputValidation.validateInt(test));
		} catch (InvalidInputException e) { }
	}
}