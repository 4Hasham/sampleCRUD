<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>123 Grocery - Sign Up</title>
	    <link href="<c:url value="/resources/style.css" />" rel="stylesheet">
	</head>
	<body>
	    <div class="head">
	        <h1 class="header">123 Grocery Store</h1>
	    </div>
    	<div class="card">
			<h1>Register</h1>
			<form:form action="/MySpringMVC/sign" method="POST" modelAttribute="saveInfo">
				<table class="form-tab">
					<tr>
						<td>
			    			<form:label path="name">Name: </form:label>								
						</td>
						<td>
							<form:input class="text" type="text" path="name" />
						</td>
					</tr>
					<tr>
						<td>
							<form:label path="pass">Password: </form:label>
						</td>
						<td>
							<form:input class="text" type="password" path="pass" />
						</td>
					</tr>
					<tr>
						<td>
							<form:label path="email">E-mail: </form:label>
						</td>
						<td>
							<form:input class="text" type="text" path="email" />
						</td>
					</tr>
					<tr>
						<td>
							<form:label path="address">Address: </form:label>
						</td>
						<td>
							<form:input class="text" type="Address" path="address" />
						</td>
					</tr>
					<tr>
						<td>
							<form:label path="phone">Phone Number: </form:label>			
						</td>
						<td>
							<form:input class="text" type="phone" path="phone" />
						</td>
					</tr>
				</table>
				<br><br>
				<input class="submit-btn" type="submit" value="Register" />
			</form:form>
			<p>Already a member? Login <a href="./">here</a>.</p>
		</div>
	</body>
</html>