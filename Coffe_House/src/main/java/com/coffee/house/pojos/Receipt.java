package com.coffee.house.pojos;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Receipt extends Order{

	Receipt() {}
	
	public Receipt(Order order,int total, int gst) {
		super(order.getCustomerName(),order.getPhoneNumber(),order.getOrderedCoffees(),order.getTimestamp());
		this.total = total;
		this.GST = gst;
	}
	
	private int total;
	private int GST;
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getGST() {
		return GST;
	}
	public void setGST(int gST) {
		GST = gST;
	}
	
	
	
}
