package com.ilp.entity;

import java.util.ArrayList;

public class Customer {

	private String CustomerCode;
	private String CustomerName;
	private ArrayList<Account>accountList;
	
	
	public ArrayList<Account> getAccountList() {
		return accountList;
	}
	public void setAccountList(ArrayList<Account> accountList) {
		this.accountList = accountList;
	}
	
	
	public Customer(String customerCode, String customerName, ArrayList<Account> accountList) {
		CustomerCode = customerCode;
		CustomerName = customerName;
		this.accountList = accountList;
	}
	public Customer(String CustomerCode,String CustomerName) {
		this.CustomerCode=CustomerCode;
		this.CustomerName=CustomerName;
	}
	public String getCustomerCode() {
		return CustomerCode;
	}
	public void setCustomerCode(String customerCode) {
		CustomerCode = customerCode;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	

}
