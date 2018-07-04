package com.coffee.house.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.house.model.OrderImpl;
import com.coffee.house.pojos.Customer;
import com.coffee.house.pojos.Order;
import com.coffee.house.pojos.Receipt;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/coffeeHouse")
@Api(value="Coffee House Orders Controller APIs")
public class OrderController {
	
	@Autowired
	private OrderImpl orderImpl;
	
	
	@RequestMapping(method=RequestMethod.POST, value="/Order")
	@ApiOperation("Post the Order of Coffees (Returns 'null', If Order fails due to coffees sold out or ordered quantity is not available)")
	@ApiResponses(value= {@ApiResponse(code=200, message="OK", response=Receipt.class)})
	public Receipt placeNewOrder(@RequestBody Order order) {
		
		return orderImpl.placeOrder(order);
	}
	
	
}
