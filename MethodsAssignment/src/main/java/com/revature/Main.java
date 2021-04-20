package com.revature;

public class Main {
	public static void main(String[] args) {
		System.out.println(printNumberInWord(5)); // print 5, should return "FIVE"
		System.out.println(reverse("hello")); // print "hello" in reverse, should return "olleh"
		System.out.println(reverse(printNumberInWord(9))); // print 9 to word in reverse, should return "ENIN"
	}
	
	public static String printNumberInWord(int i) {
		switch (i) { // returns word representation of numbers 0-9, or "OTHER" otherwise
		case 0 : return "ZERO";
		case 1 : return "ONE";
		case 2 : return "TWO";
		case 3 : return "THREE";
		case 4 : return "FOUR";
		case 5 : return "FIVE";
		case 6 : return "SIX";
		case 7 : return "SEVEN";
		case 8 : return "EIGHT";
		case 9 : return "NINE";
		default : return "OTHER";
		}
	}
	
	public static String reverse(String s) {
		String reverse = ""; // will hold the reversed string to be returned
		for (int a = s.length() - 1; a >= 0; a--) {
			reverse += s.charAt(a); // concat letters from end of argument string to the reversed string
		}
		return reverse;
	}
}