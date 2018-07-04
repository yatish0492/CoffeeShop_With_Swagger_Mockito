package com.coffee.house.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coffee.house.pojos.Order;
import com.coffee.house.pojos.OrderedCoffee;
import com.coffee.house.pojos.Receipt;
import com.coffee.house.pojos.Report;


@Component
public class OrderImpl {
	
	@Autowired
	ReportImpl reportImpl;
	

	public Receipt placeOrder(Order order) {
		
		if(validateOrderedCoffeesAvailability(order.getOrderedCoffees())) {
			return placeOrderOnSuccessfulValidation(order);
		} else {
			return null;
		}
	}
	
	public boolean validateOrderedCoffeesAvailability(List<OrderedCoffee> orderedCoffees) {
		for(OrderedCoffee eachCoffee : orderedCoffees) {
			Report coffeeReport = reportImpl.getReports().get(eachCoffee.getCoffeeName());
			if(coffeeReport != null) { 
				int TotalServingsAvailable = coffeeReport.getTotalServingsForTheDay();
				int TotalServingsSold = coffeeReport.getTotalServingssoldForTheDay();
				if((eachCoffee.getQuantity() + TotalServingsSold) > TotalServingsAvailable) {
					return false;
				}
			}
		}
		return true;
	}
	
	public Receipt placeOrderOnSuccessfulValidation(Order order) {
		int total = 0;
		for(OrderedCoffee eachCoffee : order.getOrderedCoffees()) {
			total = total + (eachCoffee.getPrice() * eachCoffee.getQuantity());
			Report coffeeReport = reportImpl.getReports().get(eachCoffee.getCoffeeName());
			if(coffeeReport != null) { 
				coffeeReport.setTotalServingssoldForTheDay(coffeeReport.getTotalServingssoldForTheDay() + eachCoffee.getQuantity());			
			}
		}
		int gst = (18/total) * 100;
		total = total + gst;
		return new Receipt(order,total,gst);	
	}
}
