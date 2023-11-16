package com.ilp.entity;

public class Services {
	private String serviceCode;
	private String serviceName;
	private Double Rate;
	
	
	
	
	public Services(String serviceCode, String serviceName, Double rate) {
		this.serviceCode = serviceCode;
		this.serviceName = serviceName;
		Rate = rate;
	}
	public String getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public Double getRate() {
		return Rate;
	}
	public void setRate(Double rate) {
		Rate = rate;
	}
	
	
	
	
}