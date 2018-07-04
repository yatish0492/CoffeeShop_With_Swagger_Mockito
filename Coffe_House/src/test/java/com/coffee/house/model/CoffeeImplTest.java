package com.coffee.house.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.coffee.house.pojos.Coffee;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class CoffeeImplTest {

	@InjectMocks
	CoffeeImpl coffeeImpl;
	
	@Mock
	ReportImpl reportImpl;
	
	
	@Test
	public void testAddNewCoffeePositive() {
		Coffee coffee = new Coffee("Capichino","Capichino Delecious Coffee",500,50);
		boolean status = coffeeImpl.addNewCoffee(coffee);
		Assert.assertTrue(status);
		Coffee resultCoffee = coffeeImpl.getCoffee("Capichino");
		Assert.assertTrue(coffee.equals(resultCoffee));
	}
	
	@Test
	public void testAddNewCoffeeNegative() {
		boolean status = coffeeImpl.addNewCoffee(null);
		Assert.assertFalse(status);
		Coffee resultCoffee = coffeeImpl.getCoffee("Capichino");
		Assert.assertNull(resultCoffee);
	}
	
	@Test
	public void testDeleteCoffeePositive() {
		boolean status = coffeeImpl.deleteCoffee("Capichino");
		Assert.assertTrue(status);
	}
	
	@Test
	public void testDeleteCoffeeNegative() {
		boolean status = coffeeImpl.deleteCoffee(null);
		Assert.assertFalse(status);
	}
}
