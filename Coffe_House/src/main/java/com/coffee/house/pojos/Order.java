package com.coffee.house.pojos;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Order {

	protected String customerName;
	protected String phoneNumber;
	protected List<OrderedCoffee> orderedCoffees;
	protected long timestamp;
	
	Order() {}
	
	public Order(String customerName, String phoneNumber, List<OrderedCoffee> orderedCoffees, long timestamp) {
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
		this.orderedCoffees = orderedCoffees;
		this.timestamp = timestamp;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public List<OrderedCoffee> getOrderedCoffees() {
		return orderedCoffees;
	}
	public void setOrderedCoffees(List<OrderedCoffee> orderedCoffees) {
		this.orderedCoffees = orderedCoffees;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
