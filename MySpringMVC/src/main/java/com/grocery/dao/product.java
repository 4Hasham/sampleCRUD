package com.grocery.dao;

import java.sql.ResultSet;    
import java.sql.SQLException;    
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;    
import org.springframework.jdbc.core.JdbcTemplate;   
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.grocery.beans.customers;
import com.grocery.beans.products; 
import javax.sql.DataSource;

public class product implements prod {
	JdbcTemplate template;
	
	public product(DataSource data) {
		template = new JdbcTemplate(data);
	}
	
	@Override
	public List<products> searchproduct(String product) {
		final String query = "SELECT * FROM (SELECT * FROM products WHERE NOT EXISTS (SELECT product_id FROM orders WHERE products.id = orders.product_id)) as pro WHERE name LIKE '%"+ product + "%'";
	    return template.query(query,new RowMapper<products>(){    
	        public products mapRow(ResultSet rs, int row) throws SQLException {    
	            products p = new products();    
	            p.setid(rs.getInt(1));    
	            p.setname(rs.getString(2));    
	            p.setprice(rs.getString(3));        
	            return p;    
	        }    
	    }); 
	}
	
	@Override
	public products getproductByID(int id) {
		final String query = "SELECT * FROM products WHERE id="+id;
		products ret = new products();
		 ret = template.query(query, new ResultSetExtractor<products>() {
		    	@Override
		    	public products extractData(ResultSet rs) throws SQLException, DataAccessException {
		    		if (rs.next()) {
		    			products c = new products();
		    			c.setid(rs.getInt("id"));
		    			c.setname(rs.getString("name"));
		    			c.setprice(rs.getString("price"));
		    			return c;
		    		}
		    		else
		    			return null;
		    	}
		 });    
	    if(ret != null) {
	    	return ret;
	    }
	    else {
	    	return null;
	    }
	}
	
	@Override
	public products getproductByName(String name) {
		final String query = "SELECT * FROM products WHERE name='"+name+"'";
		products ret = new products();
		 ret = template.query(query, new ResultSetExtractor<products>() {
		    	@Override
		    	public products extractData(ResultSet rs) throws SQLException, DataAccessException {
		    		if (rs.next()) {
		    			products c = new products();
		    			c.setid(rs.getInt("id"));
		    			c.setname(rs.getString("name"));
		    			return c;
		    		}
		    		else
		    			return null;
		    	}
		 });
		 if(ret != null) {
	    	return ret;
	    }
	    else {
	    	return null;
	    }
	}
}