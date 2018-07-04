package com.coffee.house.pojos;

import org.springframework.stereotype.Component;

@Component
public class OrderedCoffee {

	private String coffeeName;
	private int quantity;
	private int price;
	
	OrderedCoffee() {}
	
	public OrderedCoffee(String coffeeName, int quantity, int price) {
		this.coffeeName = coffeeName;
		this.quantity = quantity;
		this.price = price;
	}
	
	public String getCoffeeName() {
		return coffeeName;
	}
	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
