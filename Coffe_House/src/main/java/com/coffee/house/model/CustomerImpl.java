package com.coffee.house.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.coffee.house.pojos.Customer;

@Component
public class CustomerImpl {

	private Map<String,Customer> customers = new HashMap<String,Customer>();
	
	public void addNewCustomer(Customer customer) {
		if(customer != null) {
			customers.put(customer.getPhoneNumber(), customer);
		}
	}
	
	public Customer getCustomer(String phoneNumber) {
		return customers.get(phoneNumber);
	}

}
