package com.coffee.house.model;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.coffee.house.pojos.Report;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class ReportImplTest {
	
	@InjectMocks
	ReportImpl reportImpl;
	
	@Test
	public void testResetTheSalesInfoInReport() {
		Map<String,Report> mapOfReports = getMapOfReportsMockData1();
		reportImpl.setReports(mapOfReports);
		reportImpl.resetTheSalesInfoInReport();
		mapOfReports = reportImpl.getReports();
		for(Report eachReport : mapOfReports.values()) {
			Assert.assertEquals(0, eachReport.getTotalServingssoldForTheDay());
		}
	}
	
	private Map<String,Report> getMapOfReportsMockData1() {
		Map<String,Report> mapOfReports = new HashMap<String,Report>();
		Report report1 = new Report("Capachino",10,0);
		Report report2 = new Report("Expresso",10,0);
		mapOfReports.put(report1.getCoffeeVariety(),report1);
		mapOfReports.put(report2.getCoffeeVariety(),report2);
		return mapOfReports;
	}

}
