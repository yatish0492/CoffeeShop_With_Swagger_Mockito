package com.coffee.house.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.coffee.house.pojos.Customer;

@RunWith(MockitoJUnitRunner.class)
public class CustomerImplTest {

	@InjectMocks
	CustomerImpl customerImpl;
	
	@Test
	public void testAddNewCustomer() {
		Customer customer = new Customer("yatish","9435644623","yatish@gmail.com");
		customerImpl.addNewCustomer(customer);
		Customer customerReturned = customerImpl.getCustomer("9435644623");
		Assert.assertTrue(customer.equals(customerReturned));
	}
	
	
	@Test
	public void testGetCustomer() {
		Customer customer = new Customer("yatish","9435644623","yatish@gmail.com");
		customerImpl.addNewCustomer(customer);
		Customer customerReturned = customerImpl.getCustomer("98888555855");
		Assert.assertNull(customerReturned);
	}
}
