package com.grocery.dao;

import com.grocery.beans.customers;

public interface cust {
	public customers getcustomer(int i);
	public customers login(String n, String p);
	public int register(customers c);
}
