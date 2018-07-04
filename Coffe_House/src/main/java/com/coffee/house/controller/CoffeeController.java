package com.coffee.house.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.house.model.CoffeeImpl;
import com.coffee.house.pojos.Coffee;
import com.coffee.house.pojos.Customer;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/coffeeHouse")
@Api(value="Coffee House Coffee Controller APIs")
public class CoffeeController {
	
	@Autowired
	private CoffeeImpl coffeeImpl;

	@RequestMapping(method=RequestMethod.POST, value="/coffee/add")
	@ApiOperation("Add New Coffee")
	public String addNewCoffee(@RequestBody Coffee coffee) {
		if(coffeeImpl.addNewCoffee(coffee)) {
			return "{status : Successfully Saved New Coffee}";
		} else {
			return "{status : Failed to Save New Coffee}";
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/coffee/all")
	@ApiOperation("Get All the coffees")
	public List<Coffee> getAllCoffee() {
		return coffeeImpl.getAllCoffees();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/coffee/{coffeeName}")
	@ApiOperation("Get the Coffee Details from Coffee Name")
	@ApiResponses(value= {@ApiResponse(code=200, message="OK", response=Coffee.class)})
	public Coffee getCoffee(@PathVariable String coffeeName) {
		return coffeeImpl.getCoffee(coffeeName);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT, value="/coffee/add")
	@ApiOperation("Update Coffee Details")
	public String updateCoffee(@RequestBody Coffee coffee) {
		if(coffeeImpl.addNewCoffee(coffee)) {
			return "{status : Successfully Updated Coffee}";
		} else {
			return "{status : Failed to update Coffee}";
		}
	}
	
	
	@RequestMapping(method=RequestMethod.DELETE, value="/coffee/{coffeeName}")
	@ApiOperation("Delete Coffee from menu")
	public String deleteCoffee(@PathVariable String coffeeName) {
		coffeeImpl.deleteCoffee(coffeeName);
		return "{status : Successfully Deleted the Coffee}";
	}
}
