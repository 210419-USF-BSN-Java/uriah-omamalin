package com.shop.util;

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
	public static boolean validateMoney(String s) throws InvalidInputException {
		if (!s.isBlank() && s.matches("^\\$?(([1-9][0-9]+)|([0-9]?))(\\.[0-9]{2})?$")) {
			return true;
		} else {
			throw new InvalidInputException("input is not valid dollar amount");
		}
	}
}