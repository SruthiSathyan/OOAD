package com.ilp.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.CurrentAccount;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.Product;
import com.ilp.entity.SavingsMaxAccount;
import com.ilp.entity.Services;

public class ProductConfiguration {

	public static ArrayList<Services>  createService(ArrayList<Services> serviceList) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		Services service=null;
		char mainMenu;
		do{
			System.out.println("Enter the service name");
			String serviceName=scanner.nextLine();
			System.out.println("Enter the service ID");
			String serviceID=scanner.nextLine();
			System.out.println("Enter the service rate");
			double Rate=scanner.nextDouble();
			scanner.nextLine();
			
			serviceList.add(new Services(serviceID,serviceName,Rate));
			
			System.out.println("Do you want to add more services (y/n)");
			mainMenu=scanner.next().charAt(0);
			scanner.nextLine();
		}while(mainMenu=='y');
		return serviceList;	
			
	}


	public static void displayService(ArrayList<Services> serviceList) {
		// TODO Auto-generated method stub
		System.out.println("--------Services Available--------");
		for(Services service:serviceList)
		{
			System.out.println(service.getServiceName());
		}
	}


	public static ArrayList<Product> createProduct(ArrayList<Services> serviceList) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		ArrayList<Product> ProductList=new ArrayList<Product>();
		char menu;
		
		
		do {
			System.out.println("Which product you want to create");
			System.out.println("1.SavingsMaxAccount \t 2.CurrentAccount \t 3.LoanAccount");
			int choice=scanner.nextInt();
			switch(choice)
			{
			case 1:
				ProductList.add(createSavingsMaxAccount(serviceList));
				break;
			case 2:
				ProductList.add(createCurrentAccount(serviceList));
				break;
			case 3:
				ProductList.add(createLoanAccount(serviceList));
				break;
			}
//			ArrayList<Services> ProductServiceList=new ArrayList<Services>();
//			Scanner scanner=new Scanner(System.in);
//			System.out.println("Enter product Code");
//			ProductCode=scanner.nextLine();
//			System.out.println("Enter product Name");
//			productName=scanner.nextLine();
//			do {
//				int i=1;
//				System.out.println("--------Available services-------------");
//				for(Services service:serviceList)
//				{
//					System.out.println(i+service.getServiceName());
//					i++;
//				}
//				System.out.println("Enter the service you want to add");
//				int choice=scanner.nextInt();
//				ProductServiceList.add(serviceList.get(choice-1));
//				System.out.println("Do you want to add another service (y/n)");
//				anotherService=scanner.next().charAt(0);
//			}while(anotherService=='y');
//			ProductList.add(new Product(ProductCode,productName,ProductServiceList));
			System.out.println("Do you want to add another product (y/n)");
			menu=scanner.next().charAt(0);
//			
		}while(menu=='y');
		return ProductList ;
	}


	


	


	private static Product createLoanAccount(ArrayList<Services> serviceList) {
		// TODO Auto-generated method stub
		String ProductCode;
		String productName;
		char anotherService;
		ArrayList<Services> ProductServiceList=new ArrayList<Services>();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter product Code");
		ProductCode=scanner.nextLine();
		System.out.println("Enter product Name");
		productName=scanner.nextLine();
		do {
			int i=1;
			System.out.println("--------Available services-------------");
			for(Services service:serviceList)
			{
				System.out.println(i+service.getServiceName());
				i++;
			}
			System.out.println("Enter the service you want to add");
			int choice=scanner.nextInt();
			ProductServiceList.add(serviceList.get(choice-1));
			System.out.println("Do you want to add another service (y/n)");
			anotherService=scanner.next().charAt(0);
		}while(anotherService=='y');
		return new LoanAccount(ProductCode,productName,ProductServiceList);
	}


	private static Product createCurrentAccount(ArrayList<Services> serviceList) {
		// TODO Auto-generated method stub
		String ProductCode;
		String productName;
		char anotherService;
		ArrayList<Services> ProductServiceList=new ArrayList<Services>();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter product Code");
		ProductCode=scanner.nextLine();
		System.out.println("Enter product Name");
		productName=scanner.nextLine();
		do {
			int i=1;
			System.out.println("--------Available services-------------");
			for(Services service:serviceList)
			{
				System.out.println(i+service.getServiceName());
				i++;
			}
			System.out.println("Enter the service you want to add");
			int choice=scanner.nextInt();
			ProductServiceList.add(serviceList.get(choice-1));
			System.out.println("Do you want to add another service (y/n)");
			anotherService=scanner.next().charAt(0);
		}while(anotherService=='y');
		return new CurrentAccount(ProductCode,productName,ProductServiceList);
	}


	private static Product createSavingsMaxAccount(ArrayList<Services> serviceList) {
		// TODO Auto-generated method stub
		String ProductCode;
		String productName;
		char anotherService;
		ArrayList<Services> ProductServiceList=new ArrayList<Services>();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter product Code");
		ProductCode=scanner.nextLine();
		System.out.println("Enter product Name");
		productName=scanner.nextLine();
		do {
			int i=1;
			System.out.println("--------Available services-------------");
			for(Services service:serviceList)
			{
				System.out.println(i+service.getServiceName());
				i++;
			}
			System.out.println("Enter the service you want to add");
			int choice=scanner.nextInt();
			ProductServiceList.add(serviceList.get(choice-1));
			System.out.println("Do you want to add another service (y/n)");
			anotherService=scanner.next().charAt(0);
		}while(anotherService=='y');
		return new SavingsMaxAccount(ProductCode,productName,ProductServiceList);
	}


	public static void displayproduct(ArrayList<Product> productList) {
		// TODO Auto-generated method stub
		for(Product product:productList)
		{
			System.out.println(product.getProductName());
			System.out.println();
			System.out.println("Services Available\n");
			for(Services service:product.getServiceList())
			{
				System.out.println(service.getServiceName());
			}
			System.out.println("\n");
		}
	}


	
	
}
