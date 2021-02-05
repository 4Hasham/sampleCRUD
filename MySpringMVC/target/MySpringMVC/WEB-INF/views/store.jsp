<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>123 Grocery - Store</title>
</head>
<body>
    <h1 class="header">123 Grocery Store</h1>
    <div class="greet">
    	<table>
    		<tr>
    			<td>Welcome, guest!</td>
    			<td>
    				<a href="./processcart/<% %>"
    					<table>
	    					<tr>
	    						<td>Total items: </td>
	    					</tr>
	    					<tr>
	    						<td>Total cost: </td>
	    					</tr>
	    				</table>
    				></a>
    			</td>
    		</tr>
    	</table>
    </div>
	<div class="container">
		<div class="search-bar">
			<form:form action="" method="POST">
				<form:input type="text" path="search" />
				<form:input type="submit" path="search-btn" class="submit-btn" value="Search" />
			</form:form>
		</div>
		<div class="items-card">
		<table class="items-tab">
			<tr>
				<th>Product ID</th>
				<th>Product Name</th>
				<th>Price</th>
				<th>Action</th>
			</tr>
			<tr>
				
			</tr>
		</table>
		</div>
	</div>
</body>
</html>