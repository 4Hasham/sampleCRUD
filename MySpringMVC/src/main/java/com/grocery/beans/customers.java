package com.grocery.beans;

public class customers {
	private int id;
	private String name;
	private String pass;
	private String email;
	private String address;
	private String phone;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setname(String name) {
		this.name = name;
	}
	
	public String getname() {
		return this.name;
	}
	
	public void setpass(String pass) {
		this.pass = pass;
	}
	
	public String getpass() {
		return this.pass;
	}
	
	public void setemail(String email) {
		this.email = email;
	}
	
	public String getemail() {
		return this.email;
	}
	
	public void setaddress(String address) {
		this.address = address;
	}
	
	public String getaddress() {
		return this.address;
	}
	
	public void setphone(String phone) {
		this.phone = phone;
	}
	
	public String getphone() {
		return this.phone;
	}
}