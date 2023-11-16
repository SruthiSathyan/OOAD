package com.ilp.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.Product;
import com.ilp.entity.SavingsMaxAccount;
import com.ilp.entity.Services;

public class AccountConfiguration {


	public static ArrayList<Account> createAccount(ArrayList<Product> productList, ArrayList<Account> accountList) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		Product product=null;
		char anotherAccount;
		do {
			System.out.println("Enter Account Number:-");
	        String accountNo = scanner.nextLine();
	       
	        int i=1;
	        System.out.println("--------Accounts Available--------");
	        for(Product productElement:productList)
	        {
	        	System.out.println(i+"."+productElement.getProductName());
	        	i++;
	        }
	        System.out.println("Choose the product");
	       int choice=scanner.nextInt();
	        
	        product=productList.get(choice-1);
	        if(product instanceof SavingsMaxAccount)
	        {	
	        	SavingsMaxAccount savingsmaxaccount=(SavingsMaxAccount)product;
	        	System.out.println("Enter opening balance to be deposited");
	 	        double openingBalance = scanner.nextDouble();
	 	        scanner.nextLine();
	 	        while(openingBalance<savingsmaxaccount.getMinimumBalance())
	 	        {
	 	        	System.out.println("Error:Minimum balance of 1000 is required :add "+(savingsmaxaccount.getMinimumBalance()-openingBalance));
	 	        	openingBalance+=scanner.nextDouble();
	 	        	
	 	        }
	 	       
	 	       accountList.add(new Account(accountNo,openingBalance,savingsmaxaccount));
	 	        
	        }
	        else {
	        	System.out.println("Enter account Balance");
	        	double openingBalance = scanner.nextDouble();
	        	accountList.add(new Account(accountNo,openingBalance,product));
	        }
	        System.out.println("-------Account is active----------");
	        System.out.println("Do you want to add another account (y/n)");
	        anotherAccount=scanner.next().charAt(0);
	        scanner.nextLine();
	        
		}while(anotherAccount=='y');
		return accountList;
	}

	public static void displayCustomer(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("*************************Customer-Account Details*****************************");
		System.out.println("CustomerId\t\tCustomerName\t\tAccountType\t\tBalance");
        System.out.println("******************************************************************************");
        for(Account account:customer.getAccountList())
		{
        	Product product=account.getProduct();
			System.out.println(customer.getCustomerCode()+"\t           "+customer.getCustomerName()+"\t           "+product.getProductName()+"\t           "
					+account.getBalance());
			
		}
	}

	
	public static void getTransactionCost(Customer customer) {
	 
			Scanner scanner = new Scanner(System.in);
			int userChoice;
			Product userProductChoice;
			double userServiceChoice;
			double transactionCost;
			int transactionNo;
			ArrayList<Product> productList=new ArrayList<Product>();
			ArrayList<Services> serviceList=new ArrayList<Services>();
			System.out.println("----------Transaction Rate-----------");
			int j=1;
			for(Account account:customer.getAccountList()) {
				Product product=account.getProduct();
				System.out.println(j+"."+product.getProductName());
				productList.add(product);
				j++;
			}
			
			System.out.println("Choose the Product Account for which trasaction is to be calculated");
			userChoice=scanner.nextInt();
			userProductChoice=productList.get(userChoice-1);
			j=1;
			for(Services service:userProductChoice.getServiceList()) {
				System.out.println(j+"."+service.getServiceName());
				serviceList.add(service);
				j++;
			}
			
			System.out.println("Choose the Service for which trasaction is to be calculated");
			userChoice=scanner.nextInt();
			userServiceChoice=(serviceList.get(userChoice-1)).getRate();
			
			
			System.out.println("Enter the number of transaction");
			scanner=new Scanner(System.in);
			transactionNo=scanner.nextInt();
			transactionCost=transactionNo*userServiceChoice;
			System.out.println("your transaction bill for "+transactionNo+" transactions are:"+transactionCost);
	 
			
		}

	public static Customer createCustomer(Customer customer, ArrayList<Product> productList, ArrayList<Account> accountList) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the customer code:-");
		String CustomerCode=scanner.nextLine();
		if(customer==null)
		{
			System.out.println("Customer Id not available:Create an account");
			
		}
		accountList=createAccount(productList,accountList);
		System.out.println("Enter the customer name:-");
		String CustomerName=scanner.nextLine();
		return new Customer(CustomerCode,CustomerName,accountList);
	}

	public static Customer manageAccount(Customer customer) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("Choose the account that you want to manage");
		int i=1;
		for(Account account:customer.getAccountList())
		{
			System.out.println(i+"."+account.getProduct().getProductName());
			i++;
		}
		int accountChoice=scanner.nextInt();
		System.out.println("What yo want to do");
		System.out.println("1.Deposit \n2.Withdraw \n3.Display Balance");
		int manageChoice=scanner.nextInt();
		switch(manageChoice)
		{
		case 1:
			customer=deposit(customer,accountChoice);
			break;
		case 2:
			customer=withdraw(customer,accountChoice);
			break;
		case 3:
			displayBalance(customer,accountChoice);
	}
		return customer;
	}

	private static void displayBalance(Customer customer, int accountChoice) {
		// TODO Auto-generated method stub
		
		Product product =customer.getAccountList().get(accountChoice-1).getProduct();
		double accountBalance=customer.getAccountList().get(accountChoice-1).getBalance();
		System.out.println("Account Balance in "+product.getProductName()+" = "+accountBalance);
	}

	private static Customer withdraw(Customer customer, int accountChoice) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		Product product =customer.getAccountList().get(accountChoice-1).getProduct();
		double accountBalance;
		accountBalance=customer.getAccountList().get(accountChoice-1).getBalance();
		System.out.println("Enter the money you want to withdraw");
		double withdraw =scanner.nextDouble();
		if (product instanceof SavingsMaxAccount)
		{
			SavingsMaxAccount  savingsMaxAccount=	(SavingsMaxAccount)product;
		    while((accountBalance-withdraw)<(savingsMaxAccount.getMinimumBalance())) 
		    {
		    	System.out.println("Insufficient Balance");
		    	withdraw =scanner.nextDouble();
		    	
		    }
		    while(withdraw<=0)
	    	{
	    		System.out.println("Enter an amount greater than 0");
		    	withdraw =scanner.nextDouble();
	    	}
		    customer.getAccountList().get(accountChoice-1).setBalance(accountBalance-withdraw);
			}
		else {
			customer.getAccountList().get(accountChoice-1).setBalance(accountBalance-withdraw);
		}
		return customer;
	}

	private static Customer deposit(Customer customer, int accountChoice) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		Product product =customer.getAccountList().get(accountChoice-1).getProduct();
		double accountBalance;
		accountBalance=customer.getAccountList().get(accountChoice-1).getBalance();
		if(product instanceof LoanAccount)
		{
			
			System.out.println("Choose the method of deposit");
			int i=1;
			for(Services service:product.getServiceList())
			{
				System.out.println(i+"."+service.getServiceName());
				i++;
			}
			int serviceChoice=scanner.nextInt();
			Services service=product.getServiceList().get(serviceChoice-1);
			System.out.println("Enter the money you want to deposit");
			double deposit =scanner.nextDouble();
			if(service.getServiceName().equalsIgnoreCase("Cheque Deposit")) {
				deposit=deposit-deposit*0.003;
				System.out.println("3% will be deducted");
				customer.getAccountList().get(accountChoice-1).setBalance(accountBalance+deposit);
			}
			else {
				customer.getAccountList().get(accountChoice-1).setBalance(accountBalance+deposit);
			}

		}
		else {
			System.out.println("Enter the money you want to deposit");
			double deposit =scanner.nextDouble();
			customer.getAccountList().get(accountChoice-1).setBalance(accountBalance+deposit);
		}
		return customer;
	}

}
