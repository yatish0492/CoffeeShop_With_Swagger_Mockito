package com.coffee.house.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.house.model.CustomerImpl;
import com.coffee.house.pojos.Customer;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/coffeeHouse")
@Api(value="Coffee House Customer Controller APIs")
public class CustomerController {
	
	@Autowired
	private CustomerImpl custImpl;
	
	@RequestMapping(method=RequestMethod.POST, value="/customer/add")
	@ApiOperation("Add a new Customer")
	public String addCustomer(@RequestBody Customer customer) {
		custImpl.addNewCustomer(customer);
		return "{status : Successfully Saved}";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/customer/{phoneNumber}")
	@ApiOperation("Get the Customer details from Phone Number")
	@ApiResponses(value= {@ApiResponse(code=200, message="OK", response=Customer.class)})
	public Customer getCustomer(@PathVariable String phoneNumber) {
		//return new Customer("yatish","9035806141","yatish@gmalil.com");
		return custImpl.getCustomer(phoneNumber);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/customer/add")
	@ApiOperation("Update Customer details")
	public String updateCustomer(@RequestBody Customer customer) {
		custImpl.addNewCustomer(customer);
		return "{status : Successfully Updated}";
	}

}
