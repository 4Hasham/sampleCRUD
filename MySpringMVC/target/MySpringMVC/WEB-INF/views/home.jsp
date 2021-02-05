<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>123 Grocery - Welcome</title>
    </head>
    <body>
    <h1 class="header">123 Grocery Store</h1>
    <div class="card">
        <h1>Login</h1>
        <br><br>
        <form:form action="/login" method="POST" modelAttribute="login">
        	<p>Username: </p>
	        <form:input type="text" path="user" />
	        <br><br>
	        <p>Password: </p> 
	        <form:input type="password" path="pass" />
	        <br><br>
	        <form:input class="submit-btn" type="submit" path="submit" value="Login" />
        </form:form>
        <p>New customer? Register <a href="./register">here</a>.</p>
    </div>
    </body>
</html>