package com.shop.util;

import java.math.BigDecimal;

import com.shop.exceptions.InvalidInputException;

public class InputValidation {
	public static boolean validateIntWithinRange(String s, int lb, int ub) throws InvalidInputException {
		if (!s.isBlank() && s.matches("^([0]|[1-9][0-9]*)$")) {
			int num = Integer.parseInt(s);
			if (num >= lb && num <= ub) return true;
			else throw new InvalidInputException("input is not within range of " + lb + " and " + ub);
		} else throw new InvalidInputException("input is invalid");
	}
	public static boolean validateInt(String s) throws InvalidInputException {
		if (!s.isBlank() && s.matches("^([0]|[1-9][0-9]*)$")) return true;
		else throw new InvalidInputException("input is invalid");
	}
	public static boolean validateMoneyFormat(String s) throws InvalidInputException {
		if (!s.isBlank() && s.matches("^\\$?(([1-9][0-9]+)|([0-9]?))(\\.[0-9]{2})?$")) {
			return true;
		} else {
			throw new InvalidInputException("input is not valid dollar amount");
		}
	}
	public static boolean validateLength(String s) throws InvalidInputException {
		if (!s.isBlank() && s.length() <= 20) {
			return true;
		} else {
			throw new InvalidInputException("input is too long");
		}
	}
	public static boolean validateMoneyAmount(BigDecimal d) throws InvalidInputException {
		if (d.compareTo(BigDecimal.valueOf(1000)) < 0 && d.compareTo(BigDecimal.valueOf(0)) > 0) return true;
		else throw new InvalidInputException("input must be between 0 and 1000, exclusive");
	}
	public static boolean validateYN(String s) throws InvalidInputException {
		if (s.matches("[ynYN]")) {
			return true;
		} else {
			throw new InvalidInputException("input is not 'y' or 'n'");
		}
	}
}