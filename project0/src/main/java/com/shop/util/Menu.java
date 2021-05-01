package com.shop.util;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.shop.exceptions.BusinessException;
import com.shop.exceptions.InvalidInputException;
import com.shop.models.Customer;
import com.shop.models.Employee;
import com.shop.models.Item;
import com.shop.models.Offer;
import com.shop.models.User;
import com.shop.services.ItemService;
import com.shop.services.OfferService;
import com.shop.services.UserService;
import com.shop.services.impl.ItemServiceImpl;
import com.shop.services.impl.OfferServiceImpl;
import com.shop.services.impl.UserServiceImpl;

public class Menu {
	private static Logger log = Logger.getLogger(Menu.class);
	private static Scanner sc = new Scanner(System.in);
	private static UserService us = new UserServiceImpl();
	private static ItemService is = new ItemServiceImpl();
	private static OfferService os = new OfferServiceImpl();
	
	private static final int LENGTH = 64;
	
	// prompts
	public static void displaySign(String s) { // displays sign
		oln(displayBorder('·'));
		oln(centerString(s));
		oln(displayBorder('·'));
	}
	public static int displayMain() { // displays main menu, returns user choice
		int ch = -1;
		String s;
		
		oln("welcome to my soap shop. i sell soap.");
		o("1 - log in");
		oln("2 - register for customer account");
		oln("0 - exit");
		s = sc.nextLine();
		b();
		try {
			if (InputValidation.validateIntWithinRange(s, 0, 2)) ch = Integer.parseInt(s);
		} catch (InvalidInputException e) {
			errorln(e.getMessage());
		}
		return ch;
	}
	public static User displayLogin() {
		int id = 0;
		String s, password;
		User activeUser = null;
		
		o("enter user id:");
		s = sc.nextLine();
		try {
			if (InputValidation.validateInt(s)) id = Integer.parseInt(s);
			o("enter user password:");
			password = sc.nextLine();
			b();
			activeUser = us.login(id, password);
		} catch (InvalidInputException | BusinessException e) {
			errorln(e.getMessage());
		}
		return activeUser;
	}
	public static int displayCustomerMenu(User user) {
		int ch = -1;
		String s;
		Customer activeCustomer = us.getCustomerDetails(user);
		
		oln("logged in as: " + activeCustomer.getFirstName() + " " + activeCustomer.getLastName());
		o("1 - browse available soaps");
		o("2 - view my soaps");
		oln("3 - manage my payments");
		oln("0 - exit");
		s = sc.nextLine();
		b();
		try {
			if (InputValidation.validateIntWithinRange(s, 0, 3)) ch = Integer.parseInt(s);
		} catch (InvalidInputException e) {
			errorln(e.getMessage());
		}
		return ch;
	}
	public static void displayAvailableSoaps(User user) {
		List<Item> availableSoaps = is.getAvailableSoaps();
		Item currentSoap = null;
		String s;
		int id = 0;
		
		for (Item i : availableSoaps) {
			o(i.toString());
		}
		b();
		o("enter id of the soap you would like to buy:");
		s = sc.nextLine();
		try {
			if (InputValidation.validateInt(s)) id = Integer.parseInt(s);
				currentSoap = is.selectSoap(id);
				o("selected soap: " + currentSoap.toString());
				o("how much would you like to offer?");
				s = sc.nextLine();
				if (InputValidation.validateMoneyFormat(s)) {
					Offer o = new Offer();
					o.setAmount(BigDecimal.valueOf(Double.parseDouble(s.replaceAll("[$]", ""))));
					o.setCustomerId(user.getId());
					o.setDate(new Date());
					o.setItemId(currentSoap.getId());
					oln("your offer id is: " + os.makeOffer(o));
				}
		} catch (InvalidInputException | BusinessException e) {
			errorln(e.getMessage());
		}
	}
	public static void displayMySoaps(User user) {
		oln("your soaps");
		List<Item> mySoaps = is.getMySoaps(user);
		
		for (Item i : mySoaps) {
			o(i.toString());
		}
		b();
	}
	public static int displayEmployeeMenu(User user) {
		int ch = -1;
		String s;
		Employee activeEmployee = us.getEmployeeDetails(user);
		
		oln("logged in as: " + activeEmployee.getFirstName() + " " + activeEmployee.getLastName());
		o("1 - manage soaps");
		o("2 - view pending offers");
		oln("3 - view customer payments");
		oln("0 - exit");
		s = sc.nextLine();
		b();
		try {
			if (InputValidation.validateIntWithinRange(s, 0, 3)) ch = Integer.parseInt(s);
		} catch (InvalidInputException e) {
			errorln(e.getMessage());
		}
		return ch;
	}
	public static int displayManageSoaps() {
		int ch = -1;
		String s;
		
		o("1 - add soap");
		o("2 - delete soap");
		oln("3 - edit soap");
		oln("0 - exit");
		s = sc.nextLine();
		b();
		try {
			if (InputValidation.validateIntWithinRange(s, 0, 3)) ch = Integer.parseInt(s);
		} catch (InvalidInputException e) {
			errorln(e.getMessage());
		}
		return ch;
	}
	public static void displayAddSoap() {
		Item soap = new Item();
		String s;
		
		o("enter name of soap:");
		s = sc.nextLine();
		try {
			if (InputValidation.validateLength(s)) {
				soap.setItemName(s);
				o("enter price of soap:");
				s = sc.nextLine();
				b();
				if (InputValidation.validateMoneyFormat(s)) {
					BigDecimal dollar = BigDecimal.valueOf(Double.parseDouble(s.replaceAll("[$]", "")));
					if (InputValidation.validateMoneyAmount(dollar)) {
						soap.setPrice(dollar);
						oln(is.selectSoap(is.addSoap(soap)).toString() + " has been added to the shop");
					}
				}
			}
		} catch (InvalidInputException | BusinessException e) {
			errorln(e.getMessage());
		}
	}
	public static void displayDeleteSoap() {
		List<Item> availableSoaps = is.getAvailableSoaps();
		Item currentSoap = null;
		String s;
		int id = 0;
		
		for (Item i : availableSoaps) {
			o(i.toString());
		}
		b();
		o("enter id of the soap to delete:");
		s = sc.nextLine();
		try {
			if (InputValidation.validateInt(s)) id = Integer.parseInt(s);
				currentSoap = is.selectSoap(id);
				o("selected soap: " + currentSoap.toString());
				o("delete this soap? (y/n)");
				s = sc.nextLine();
				if (InputValidation.validateYN(s)) {
					if (s.toLowerCase().equals("y")) {
						is.deleteSoap(currentSoap);
						oln("soap deleted");
					} else {
						oln("deletion cancelled");
					}
				}
		} catch (InvalidInputException | BusinessException e) {
			errorln(e.getMessage());
		}
	}
	public static void displayEditSoap() {
		List<Item> availableSoaps = is.getAvailableSoaps();
		Item currentSoap = null;
		String s;
		int id = 0, ch = 0;
		
		for (Item i : availableSoaps) {
			o(i.toString());
		}
		b();
		o("enter id of the soap to edit:");
		s = sc.nextLine();
		try {
			if (InputValidation.validateInt(s)) id = Integer.parseInt(s);
				currentSoap = is.selectSoap(id);
				o("selected soap: " + currentSoap.toString());
				o("edit this soap? (y/n)");
				s = sc.nextLine();
				if (InputValidation.validateYN(s)) {
					if (s.toLowerCase().equals("y")) {
						o("1 - edit name");
						o("2 - edit price");
						s = sc.nextLine();
						if (InputValidation.validateIntWithinRange(s, 1, 2)) ch = Integer.parseInt(s);
						o(currentSoap.toString());
						switch (ch) {
						case 1 :
							o("enter new name:");
							s = sc.nextLine();
							if (InputValidation.validateLength(s)) {
								is.updateSoapName(currentSoap, s);
								oln("name update successful");
							}
							break;
						case 2 :
							o("enter new price:");
							s = sc.nextLine();
							if (InputValidation.validateMoneyFormat(s)) {
								BigDecimal dollar = BigDecimal.valueOf(Double.parseDouble(s.replaceAll("[$]", "")));
								if (InputValidation.validateMoneyAmount(dollar)) {
									is.updateSoapPrice(currentSoap, dollar);
									oln("price update successful");
								}
							}
							break;
						}
					} else {
						oln("edit cancelled");
					}
				}
		} catch (InvalidInputException | BusinessException e) {
			errorln(e.getMessage());
		}
	}
	
	// utility
	private static String centerString(String s) { // center string 's' within the display length
		if (s.length() >= LENGTH) {
			return s;
		} else {
			StringBuilder sb = new StringBuilder();
			
			for (int a = 1; a <= (LENGTH - s.length()) / 2; a++) {
				sb.append(' ');
			}
			return sb.append(s).toString();
		}
	}
	private static String displayBorder(char c) { // displays a border of char 'c' within the display
		StringBuilder sb = new StringBuilder();
		
		for (int a = 1; a <= LENGTH; a++) {
			sb.append(c);
		}
		return sb.toString();
	}
	public static void b() { // outputs new line
		log.info("");
	}
	public static void o(String s) { // outputs string 's' without new line
		log.info(s);
	}
	public static void oln(String s) { // outputs string 's' with new line
		log.info(s);
		log.info("");
	}
	public static void errorln(String s) { // error outputs string 's'
		log.error(s);
		log.info("");
	}
}