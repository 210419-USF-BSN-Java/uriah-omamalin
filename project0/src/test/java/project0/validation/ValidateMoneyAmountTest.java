package project0.validation;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.shop.exceptions.InvalidInputException;
import com.shop.util.InputValidation;

@RunWith(Parameterized.class)
public class ValidateMoneyAmountTest {
	@Parameters
	public static Collection<Object[]> cases() {
		return Arrays.asList(new Object[][] {
			{BigDecimal.valueOf(0), false}, // lower bound test of range 0-1000, exclusive
			{BigDecimal.valueOf(1000), false}, // upper bound test
			{BigDecimal.valueOf(-40), false}, // below lb
			{BigDecimal.valueOf(1200), false}, // above ub
			{BigDecimal.valueOf(22.22), true}, // within bound
			{BigDecimal.valueOf(977.11), true} // within bound
		});
	}
	
	private final BigDecimal test;
	private final boolean isValid;
	
	public ValidateMoneyAmountTest(BigDecimal test, boolean isValid) {
		this.test = test;
		this.isValid = isValid;
	}
	
	@Test
	public void testValidateMoneyAmount() {
		try {
			assertEquals(isValid, InputValidation.validateMoneyAmount(test));
		} catch (InvalidInputException e) { }
	}
}