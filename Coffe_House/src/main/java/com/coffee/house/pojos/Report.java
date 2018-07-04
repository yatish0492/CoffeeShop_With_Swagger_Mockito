package com.coffee.house.pojos;

public class Report {

	private String CoffeeVariety;
	private int TotalServingsForTheDay;
	private int TotalServingssoldForTheDay;
	
	public Report() {}
	
	public Report(String CoffeeVariety, int TotalServingsForTheDay, int TotalServingssoldForTheDay) {
		this.CoffeeVariety = CoffeeVariety;
		this.TotalServingsForTheDay = TotalServingsForTheDay;
		this.TotalServingssoldForTheDay = TotalServingssoldForTheDay;
	}
	
	public String getCoffeeVariety() {
		return CoffeeVariety;
	}
	public void setCoffeeVariety(String coffeeVariety) {
		CoffeeVariety = coffeeVariety;
	}
	public int getTotalServingsForTheDay() {
		return TotalServingsForTheDay;
	}
	public void setTotalServingsForTheDay(int totalServingsForTheDay) {
		TotalServingsForTheDay = totalServingsForTheDay;
	}
	public int getTotalServingssoldForTheDay() {
		return TotalServingssoldForTheDay;
	}
	public void setTotalServingssoldForTheDay(int totalServingssoldForTheDay) {
		TotalServingssoldForTheDay = totalServingssoldForTheDay;
	}
	
	
}
