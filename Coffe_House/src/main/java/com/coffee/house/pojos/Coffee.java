package com.coffee.house.pojos;

import org.springframework.stereotype.Component;

@Component
public class Coffee {

	private String name;
	private String description;
	private int totalServingsPerDay;
	private int price;
	
	public Coffee() {}
	
	public Coffee(String name, String description, int totalServingsPerDay, int price) {
		this.name = name;
		this.description = description;
		this.totalServingsPerDay = totalServingsPerDay;
		this.price = price;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getTotalServingsPerDay() {
		return totalServingsPerDay;
	}
	public void setTotalServingsPerDay(int totalServingsPerDay) {
		this.totalServingsPerDay = totalServingsPerDay;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Coffee) {
			Coffee coffee = (Coffee)obj;
			if(this.name == coffee.getName()) {
				return true;
			}
		}
		return false;
	}
}
