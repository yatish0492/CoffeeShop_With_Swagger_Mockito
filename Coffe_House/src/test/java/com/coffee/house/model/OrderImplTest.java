package com.coffee.house.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.coffee.house.pojos.Order;
import com.coffee.house.pojos.OrderedCoffee;
import com.coffee.house.pojos.Receipt;
import com.coffee.house.pojos.Report;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class OrderImplTest {

	@InjectMocks
	OrderImpl orderImpl;
	
	@Mock
	ReportImpl reportImpl;
	
	@Test
	public void testValidateOrderedCoffeesAvailabilityValidScenario() {
		List<OrderedCoffee> listOfOrderedCoffee = getListOfOrderedCoffeeMockData2();
		
		Map<String,Report> mapOfReports = getMapOfReportsMockData1();
		Mockito.doReturn(mapOfReports).when(reportImpl).getReports();
		
		boolean status = orderImpl.validateOrderedCoffeesAvailability(listOfOrderedCoffee);
		Assert.assertTrue(status);
	}
	
	@Test
	public void testValidateOrderedCoffeesAvailabilityInValidScenario() {
		List<OrderedCoffee> listOfOrderedCoffee = getListOfOrderedCoffeeMockData1();
		
		Map<String,Report> mapOfReports = getMapOfReportsMockData2();
		Mockito.doReturn(mapOfReports).when(reportImpl).getReports();
		
		boolean status = orderImpl.validateOrderedCoffeesAvailability(listOfOrderedCoffee);
		Assert.assertFalse(status);
	}
	
	@Test
	public void testPlaceOrderOnSuccessfulValidation() {
		List<OrderedCoffee> listOfOrderedCoffee = getListOfOrderedCoffeeMockData2();
		Order order = new Order("yatish","9568456123",listOfOrderedCoffee,56845665);
		
		Map<String,Report> mapOfReports = getMapOfReportsMockData1();
		Mockito.doReturn(mapOfReports).when(reportImpl).getReports();
		
		Receipt receipt = orderImpl.placeOrderOnSuccessfulValidation(order);
		Assert.assertTrue(receipt.getTotal() == 400);
	}
	
	@Test
	public void testPlaceOrderValidCase() {
		List<OrderedCoffee> listOfOrderedCoffee = getListOfOrderedCoffeeMockData2();
		Order order = new Order("yatish","9568456123",listOfOrderedCoffee,56845665);
		
		Map<String,Report> mapOfReports = getMapOfReportsMockData1();
		Mockito.doReturn(mapOfReports).when(reportImpl).getReports();
		
		Receipt receipt = orderImpl.placeOrder(order);
		Assert.assertTrue(receipt.getTotal() == 400);
	}
	
	@Test
	public void testPlaceOrderInvalidCase() {
		List<OrderedCoffee> listOfOrderedCoffee = getListOfOrderedCoffeeMockData1();
		Order order = new Order("yatish","9568456123",listOfOrderedCoffee,56845665);
		
		Map<String,Report> mapOfReports = getMapOfReportsMockData1();
		Mockito.doReturn(mapOfReports).when(reportImpl).getReports();
		
		Receipt receipt = orderImpl.placeOrder(order);
		Assert.assertNull(receipt);
	}
	
	private Map<String,Report> getMapOfReportsMockData1() {
		Map<String,Report> mapOfReports = new HashMap<String,Report>();
		Report report1 = new Report("Capachino",10,0);
		Report report2 = new Report("Expresso",10,0);
		mapOfReports.put(report1.getCoffeeVariety(),report1);
		mapOfReports.put(report2.getCoffeeVariety(),report2);
		return mapOfReports;
	}
	
	private Map<String,Report> getMapOfReportsMockData2() {
		Map<String,Report> mapOfReports = new HashMap<String,Report>();
		Report report1 = new Report("Capachino",2,0);
		Report report2 = new Report("Expresso",2,0);
		mapOfReports.put(report1.getCoffeeVariety(),report1);
		mapOfReports.put(report2.getCoffeeVariety(),report2);
		return mapOfReports;
	}
	
	private List<OrderedCoffee> getListOfOrderedCoffeeMockData1() {
		List<OrderedCoffee> listOfOrderedCoffee = new ArrayList<OrderedCoffee>();
		OrderedCoffee coffee1 = new OrderedCoffee("Capachino",12,50);
		OrderedCoffee coffee2 = new OrderedCoffee("Expresso",5,60);
		listOfOrderedCoffee.add(coffee1);
		listOfOrderedCoffee.add(coffee2);
		return listOfOrderedCoffee;
	}
	
	private List<OrderedCoffee> getListOfOrderedCoffeeMockData2() {
		List<OrderedCoffee> listOfOrderedCoffee = new ArrayList<OrderedCoffee>();
		OrderedCoffee coffee1 = new OrderedCoffee("Capachino",2,50);
		OrderedCoffee coffee2 = new OrderedCoffee("Expresso",5,60);
		listOfOrderedCoffee.add(coffee1);
		listOfOrderedCoffee.add(coffee2);
		return listOfOrderedCoffee;
	}
}
