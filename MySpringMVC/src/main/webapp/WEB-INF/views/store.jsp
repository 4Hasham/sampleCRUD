<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.grocery.beans.products" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>123 Grocery - Store</title>
	    <link href="<c:url value="/resources/style.css" />" rel="stylesheet">
	</head>
	<body>
	    <div class="head">
	        <h1 class="header">123 Grocery Store</h1>
	    </div>	   
	     <div class="greet">
	    	<p>Welcome, ${name}!</p>
	    	<a href="./processcart?id=${id}">View Cart</a>
	    </div>
		<div class="card">
			<div class="search-bar">
				<form:form action="/MySpringMVC/getresults" method="POST" modelAttribute="searchbox">
					<form:input class="text" path="text" type="text" />
					<form:hidden path="id" value="${id}" />
					<form:hidden path="name" value="${name}" />
					<input type="submit" class="submit-btn" value="Search" />
				</form:form>
			</div>
			<br>
			<div class="items-card">
				<table class="items-tab">
					<tr>
						<th>Product ID</th>
						<th>Product Name</th>
						<th>Price</th>
						<th>Action</th>
					</tr>
					<c:forEach var="prod" items="${prods}">
					<tr>
						<td>${prod.getid()}</td>
						<td>${prod.getname()}</td>
						<td>${prod.getprice()}</td>
						<td><a href="/MySpringMVC/addItem?id=${id}&pid=${prod.getid()}&name=${name}&txt=${searchbox.gettext()}">+</a></td>
					</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</body>
</html>