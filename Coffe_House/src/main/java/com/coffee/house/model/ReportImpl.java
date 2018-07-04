package com.coffee.house.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.coffee.house.pojos.Report;

@Component
public class ReportImpl {

	Map<String,Report> reports = new HashMap<String,Report>();

	public Map<String, Report> getReports() {
		return reports;
	}

	public void setReports(Map<String, Report> reports) {
		this.reports = reports;
	}
	
	public void resetTheSalesInfoInReport() {
		Set<String> coffeeNames = reports.keySet();
		for(String coffee : coffeeNames) {
			Report report = reports.get(coffee);
			report.setTotalServingssoldForTheDay(0);
			reports.put(coffee, report);
		}
	}
	
	
}
