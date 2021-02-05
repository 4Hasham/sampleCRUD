package com.grocery.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.grocery.beans.orders;
import com.grocery.beans.products;  
import javax.sql.DataSource;

public class order implements ord {

	JdbcTemplate template;
	
	public order(DataSource data) {
		template = new JdbcTemplate(data);
	}
	
	@Override
	public int placeOrder(orders o) {
		if(o.getproduct_id() != 0 && o.getcustomer_id() != 0) {
			int cid = o.getcustomer_id();
			int pid = o.getproduct_id();
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			LocalDateTime current = LocalDateTime.now();  
			final String query = "INSERT INTO orders(product_id, customer_id, date) VALUES("+ pid +", "+ cid +", '"+ format.format(current) +"')";
			if(template.update(query) > 0) {
				return 0;
			}
			else {
				return 1;
			}
		}
		else {
			return 1;
		}
	}
	@Override
	public int deleteOrder(int id, int pid) {
		if(id != 0 && pid != 0) {
			final String query = "DELETE FROM orders WHERE customer_id="+id+" AND product_id="+pid;
			if(template.update(query) > 0) {
				return 0;
			}
			else {
				return 1;
			}
		}
		else {
			return 1;
		}
	}
	
	@Override
	public List<orders> getOrders(int id) {
		if(id != 0) {
			String query = "SELECT * FROM orders WHERE customer_id="+id;
		    return template.query(query,new RowMapper<orders>(){    
		        public orders mapRow(ResultSet rs, int row) throws SQLException {    
		            orders p = new orders();    
		            p.setid(rs.getInt(1));    
		            p.setcustomer_id(rs.getInt(3));    
		            p.setproduct_id(rs.getInt(2));        
		            return p;    
		        }    
		    }); 
		}
		else {
			return null;
		}
	}
}