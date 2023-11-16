package com.ilp.utility;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.Product;
import com.ilp.entity.Services;
import com.ilp.service.AccountConfiguration;
import com.ilp.service.ProductConfiguration;

public class AccountUtility {

	 
		public static void main(String[] args) {
	 
			Scanner scanner = new Scanner(System.in);
			char goToMenu;
			char goToMainMenu;
			Customer customer=null;
			ArrayList<Services> serviceList = new ArrayList<Services>();
			ArrayList<Product> productList = new ArrayList<Product>();
			ArrayList<Account> accountList = new ArrayList<Account>();
			do {
				System.out.println("-----Menu Creation-----");
				System.out.println("1.Create Service \n2.Display Service \n3.Create Product \n4.Display product \n5.Exit");
				System.out.println("Enter your choice:");
				int menuChoice = scanner.nextInt();
				switch(menuChoice) {
				case 1:
					serviceList = ProductConfiguration.createService(serviceList);
					break;
				case 2:
					ProductConfiguration.displayService(serviceList);
					break;
				case 3:
					productList=ProductConfiguration.createProduct(serviceList);
					break;
				case 4:
					ProductConfiguration.displayproduct(productList);
					break;
//				case 5:
//					break;
				}
				System.out.println("Do you want to go back to main menu (y/n):");
				goToMenu = scanner.next().charAt(0);
			}
			while (goToMenu == 'y');
			
			System.out.println("*****Welcome To Bank*****");
			do {
			System.out.println("1.Create Customer \n2.Display Accounts \n3.TransactionBill \n4.Manage Account");
			System.out.println("Enter your choice:");
			int userMenuChoice = scanner.nextInt();
			switch(userMenuChoice) {
			case 1:
//				accountList=AccountConfiguration.createAccount(productList);
				customer=AccountConfiguration.createCustomer(customer,productList, accountList);
				
				break;
			case 2:
				AccountConfiguration.displayCustomer(customer);
				break;
			case 3:
				AccountConfiguration.getTransactionCost(customer);
				break;
			case 4:
				customer=AccountConfiguration.manageAccount(customer);
				break;
			}
			
				
			System.out.println("Do you want to go back to main menu (y/n):");
			goToMainMenu = scanner.next().charAt(0);
			
		}while(goToMainMenu=='y');
		}
	 
	}
	 
