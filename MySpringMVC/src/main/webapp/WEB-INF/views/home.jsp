<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>123 Grocery - Welcome</title>
    	<link href="<c:url value="/resources/style.css" />" rel="stylesheet">
    </head>
    <body>
    <div class="head">
        <h1 class="header">123 Grocery Store</h1>
    </div>
    <div class="card">
        <h1>Login</h1>
        <br><br>
        <form:form action="/MySpringMVC/login" method="POST" modelAttribute="login">
	        <table class="form-tab">
		        <tr>
		        	<td>
		        		<form:label path="name">Name</form:label>
		        	</td>
		        	<td>
		        		<form:input class="text" type="text" path="name" />
		        	</td>
		        </tr>
		        <tr>
		        	<td>
		        		<form:label path="pass">Password</form:label> 
		        	
		        	</td>
		        	<td>
		        		<form:input class="text" type="password" path="pass" />
		        	</td>
		        </tr>
		    </table>
		    <br><br>
	        <input class="submit-btn" type="submit" value="Login" />
        </form:form>
        <p>New customer? Register <a href="./register">here</a>.</p>
    </div>
    </body>
</html>