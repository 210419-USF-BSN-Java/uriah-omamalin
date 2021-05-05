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
							case 2 : Menu.displayMySoaps(activeUser); break;
							case 3 : Menu.displayProcessedOffersToCustomer(activeUser); break;
							}
							break;
						case EMPLOYEE :
							ch = Menu.displayEmployeeMenu(activeUser);
							switch (ch) {
							case 1 : 
								ch = Menu.displayManageSoaps();
								switch (ch) {
								case 1 : Menu.displayAddSoap(); break;
								case 2 : Menu.displayDeleteSoap(); break;
								case 3 : Menu.displayEditSoap(); break;
								}
								ch = -1;
								break;
							case 2 : Menu.displayPendingOffers(); break;
							case 3 : Menu.displayCustomerPayments(); break;
							}
							break;
						case MANAGER : 
							Menu.oln("manager menu under construction");
							activeUser = Menu.displayLogin();
							break;
						}
					} while (ch != 0);
				}
			ch = -1;
			break;
			case 2 : Menu.displayRegister(); break;
			}
		} while (ch != 0);
		Menu.oln("hope to see you again!");
	}
}