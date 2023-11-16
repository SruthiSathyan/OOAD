package com.ilp.entity;

import java.util.ArrayList;

public class LoanAccount extends Product {
double chequeDeposit=0.3;

public LoanAccount(String productCode, String productName, ArrayList<Services> serviceList) {
	super(productCode, productName, serviceList);

}

public double getChequeDeposit() {
	return chequeDeposit;
}

public void setChequeDeposit(double chequeDeposit) {
	this.chequeDeposit = chequeDeposit;
}

}
