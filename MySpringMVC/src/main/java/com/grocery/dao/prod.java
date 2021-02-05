package com.grocery.dao;

import java.util.List;

import com.grocery.beans.products;

public interface prod {
	public List<products> searchproduct(String product);
	public products getproductByID(int id);
	public products getproductByName(String name);
}