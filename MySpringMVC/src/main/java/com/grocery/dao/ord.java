package com.grocery.dao;

import java.util.List;

import com.grocery.beans.orders;

public interface ord {

	public int placeOrder(orders o);
	public int deleteOrder(int id, int pid);
	public List<orders> getOrders(int id);
	
}
