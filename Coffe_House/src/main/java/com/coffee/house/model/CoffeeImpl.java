package com.coffee.house.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coffee.house.pojos.Coffee;
import com.coffee.house.pojos.Report;

@Component
public class CoffeeImpl {
	
	@Autowired
	ReportImpl reportImpl;

	Map<String,Coffee> coffees = new HashMap<String,Coffee>();
	
	public boolean addNewCoffee(Coffee coffee) {
		if(coffee != null) {
			coffees.put(coffee.getName(),coffee);
			Report report = new Report();
			report.setCoffeeVariety(coffee.getName());
			report.setTotalServingsForTheDay(coffee.getTotalServingsPerDay());
			reportImpl.getReports().put(coffee.getName(), report);
			return true;
		} else {
			return false;
		}
	}
	
	public Coffee getCoffee(String coffeeName) {
		return coffees.get(coffeeName);
	}
	
	public List<Coffee> getAllCoffees() {
		return new ArrayList<Coffee>(coffees.values());
	}
	
	public boolean deleteCoffee(String coffeeName) {
		if(coffeeName != null) {
			coffees.remove(coffeeName);
			reportImpl.getReports().remove(coffeeName);
			return true;
		} else {
			return false;
		}
	}
}
