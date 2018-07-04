package com.coffee.house.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.house.model.ReportImpl;
import com.coffee.house.pojos.Report;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/coffeeHouse")
@Api(value="Coffee House Reports Controller APIs")
public class ReportController {
	
	@Autowired
	ReportImpl reportImpl;
	
	@RequestMapping(method=RequestMethod.GET, value="/report")
	@ApiOperation("Get the Report for coffee sales for the day")
	@ApiResponses(value= {@ApiResponse(code=200, message="OK", response=Report.class)})
	public List<Report> getReport() {
		return new ArrayList<Report>(reportImpl.getReports().values());
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/report/reset")
	@ApiOperation("Reset the report to 0 sold at end of th day")
	public String resetTheDaySaleReport() {
		reportImpl.resetTheSalesInfoInReport();
		return "{status : Reset of day says report successful}";
	}

}
