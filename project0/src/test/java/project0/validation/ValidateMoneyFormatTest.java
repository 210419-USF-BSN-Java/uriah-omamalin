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
public class ValidateMoneyFormatTest {
	@Parameters
	public static Collection<Object[]> cases() {
		return Arrays.asList(new Object[][] {
			{"$9.8", false}, // must have 2 decimal places
			{"09.00", false}, // leading 0 not necessary
			{"$88.", false}, // decimal must be followed by two digits
			{"$08", false}, // leading 0 not necessary
			{"abc", false}, // invalid money format
			{"1", true}, // no dollar sign, no decimal
			{"2.00", true}, // no dollar sign, 2 decimal places
			{".50", true}, // no leading 0, 2 decimal places
			{"$.50", true}, // dollar sign, no leading 0, 2 decimal places
			{"$5", true}, // dollar sign, no decimal
			{"$10.00", true} // dollar sign, 2 decimal places
		});
	}
	
	private final String test;
	private final boolean isValid;
	
	public ValidateMoneyFormatTest(String test, boolean isValid) {
		this.test = test;
		this.isValid = isValid;
	}
	
	@Test
	public void testValidateMoneyFormat() {
		try {
			assertEquals(isValid, InputValidation.validateMoneyFormat(test));
		} catch (InvalidInputException e) { }
	}
}