package com.grocery.dao;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;    
import com.grocery.beans.customers;     
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class customer implements cust {
	private JdbcTemplate template;
	
	public customer(DataSource data) {
		template = new JdbcTemplate(data);
	}
	
//	public void setTemplate(JdbcTemplate template) {
	//	this.template = template;
	//}
	@Override
	public customers getcustomer(int i) {
		if(i > 0) {
			final String query = "SELECT * FROM customers WHERE `id`="+ i;
			customers ret = new customers();
		    ret = template.query(query, new ResultSetExtractor<customers>() {
		    	@Override
		    	public customers extractData(ResultSet rs) throws SQLException, DataAccessException {
		    		if (rs.next()) {
		    			customers c = new customers();
		    			c.setId(rs.getInt("id"));
		    			c.setname(rs.getString("name"));
		    			c.setemail(rs.getString("email"));
		    			c.setaddress(rs.getString("address"));
		    			c.setphone(rs.getString("phone"));
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
		else {
			return null;
		}
	}
	
	@Override
	public customers login(String n, String p) {
		String name = n.trim();
		String pass = p.trim();
		if(n != "" && p != "") {
			final String query = "SELECT * FROM customers WHERE `name`='"+ name +"' AND `password`='"+ pass +"'";
			customers ret = new customers();
		    ret = template.query(query, new ResultSetExtractor<customers>() {
		    	@Override
		    	public customers extractData(ResultSet rs) throws SQLException, DataAccessException {
		    		if (rs.next()) {
		    			customers c = new customers();
		    			c.setId(rs.getInt("id"));
		    			c.setname(rs.getString("name"));
		    			c.setemail(rs.getString("email"));
		    			c.setaddress(rs.getString("address"));
		    			c.setphone(rs.getString("phone"));
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
		else {
			return null;
		}
	}
	
	
	public int register(customers c) {
		String name = c.getname().trim();
		String pass = c.getpass().trim();
		String email = c.getemail().trim();
		String addr = c.getaddress().trim();
		String phone = c.getphone().trim();
		
		if(name != "" && pass != "" && email != "" && addr != "" && phone != "") {
			final String query = "SELECT * FROM customers WHERE name='"+name+"'";
			customers ret = new customers();
		    ret = template.query(query, new ResultSetExtractor<customers>() {
		    	@Override
		    	public customers extractData(ResultSet rs) throws SQLException, DataAccessException {
		    		if (rs.next()) {
		    			customers c = new customers();
		    			c.setId(rs.getInt("id"));
		    			c.setname(rs.getString("name"));
		    			c.setemail(rs.getString("email"));
		    			c.setaddress(rs.getString("address"));
		    			c.setphone(rs.getString("phone"));
		    			return c;
		    		}
		    		else
		    			return null;
		    	}
		    });    
		    if(ret == null) {
		    	final String query1 = "INSERT INTO customers(name, password, email, address, phone) VALUES('"+ name +"', '"+ pass +"', '"+ email +"', '"+ addr +"', '"+ phone +"')";
		    	if(template.update(query1) > 0) {
		    		return 0;
		    	}
		    	else {
		    		return -2;
		    	}
		    }
		    else {
		    	return 1;
		    }
		}
		else {
			return -1;
		}
	}
}