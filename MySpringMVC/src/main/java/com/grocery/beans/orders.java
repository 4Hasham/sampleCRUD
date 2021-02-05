package com.grocery.beans;

public class orders {
	private int id;
	private int product_id;
	private int customer_id;
	private String date;
	
	public void setid(int id) {
		this.id = id;
	}
	
	public int getid() {
		return this.id;
	}
	
	public void setproduct_id(int product_id) {
		this.product_id = product_id;
	}
	
	public int getproduct_id() {
		return this.product_id;
	}
	
	public void setcustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	
	public int getcustomer_id() {
		return this.customer_id;
	}
	
	public void setdate(String date) {
		this.date = date;
	}
	
	public String getdate() {
		return this.date;
	}
}