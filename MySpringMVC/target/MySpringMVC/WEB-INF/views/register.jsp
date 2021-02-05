<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>123 Grocery - Sign Up</title>
</head>
<body>
    <h1 class="header">123 Grocery Store</h1>
	<div class="card">
		<h1>Register</h1>
		<form:form action="/sign" method="POST" modelAttribute="saveInfo">
		    <form:label path="user">Username: </form:label>
			<form:input type="text" path="user" />
			<br><br>
			<form:label path="pass">Password: </form:label>
			<form:input type="password" path="pass" />
			<br><br>
			<form:label path="email">E-mail: </form:label>
			<form:input type="text" path="email" />
			<br><br>
			<form:label path="addr">Address: </form:label>
			<form:input type="Address" path="addr" />
			<br><br>
			<form:label path="phone">Phone Number: </form:label>
			<form:input type="phone" path="phone" />
			<br><br>
			<form:input class="submit-btn" type="submit" path="submit" value="Register" />
		</form:form>
	</div>
</body>
</html>