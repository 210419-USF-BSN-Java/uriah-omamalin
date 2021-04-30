package com.shop.main;

import com.shop.models.User;
import com.shop.models.enums.UserType;
import com.shop.util.Menu;

public class Main {
	public static void main(String[] args) {
		int ch = 0;
		User activeUser = null;
		
		do {
			Menu.displaySign("¯`·.¸¸.·´¯`· MY SOAP SHOP ·´¯`·.¸¸.·´¯");
			ch = Menu.displayMain();
			switch (ch) {
			case 1 :
				activeUser = Menu.displayLogin();
				if (activeUser != null) {
					do {
						switch (UserType.values()[activeUser.getUserType()]) {
						case CUSTOMER :
							ch = Menu.displayCustomerMenu(activeUser);
							switch (ch) {
							case 1 : Menu.displayAvailableSoaps(activeUser); break;
							case 2 : Menu.oln("my soaps under construction"); break;
							case 3 : Menu.oln("my payments under construction"); break;
							}
						break;
						case EMPLOYEE :	Menu.oln("employee under construction"); break;
						case MANAGER : Menu.oln("manager under construction"); break;
						}
					} while (ch != 0);
				}
			break;
			case 2 : Menu.oln("registration under construction"); break;
			}
		} while (ch != 0);
		Menu.oln("c u l8r");
	}
}