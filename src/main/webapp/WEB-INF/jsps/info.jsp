<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Home Page</title>
	<link rel="stylesheet" type="text/css" href="globalStyle.css">
	<link rel="stylesheet" type="text/css" href="userInfoStyle.css">
	<link rel="stylesheet" type="text/css" href="registerStyle.css">
</head>
<body>
	
	<div style="top:0%;height:100%;margin:0;overflow:auto" class="box">
		<h1 style="text-align:center;">${user.firstName} information</h1>	
		<hr>
	
		<form:form id="updateForm" action="" method="POST" modelAttribute="user">
		
			<form:errors path = "*" element = "div" style="color:red;background-color:FFBABA;"/>
			<div style="color:red;background-color:FFBABA;">${emailExists}</div>
			
			<label><b>ID:</b></label>
			<input type="text" name="id" value="${user.id}" readonly><br>
			
			<label><b>Firstname:</b></label>
			<input type="text" name="firstName" value ="${user.firstName}"><br>
			
			<label><b>Lastname:</b></label>
			<input type="text" name="lastName" value ="${user.lastName}"><br>
			
			<label><b>Email:</b></label>
			<input type="email" name="email" value ="${user.email}"><br>
			<label><b>Password:</b></label>
			<input type="text" name="password" value ="${user.password}"><br>
			
			<label><b>Phone Number:</b></label>
			<input type="text" name="phoneNumber" value ="${user.phoneNumber}"><br>
			
			
			<label><b>Company:</b></label>
			<input type="text" name="companyName" value ="${user.companyName}"><br>
			
			
			<div class="buttons">
				<input id="Apply" type="submit" value="Apply changes" onclick="EditFunc()">
				<input id="DisconnectButton" type="submit" value="Disconnect" onclick="DisconnectFunc()">
			</div>
			
		</form:form>
		
	</div>
		
	
	<script src="buttonActions.js"></script>
</body>
</html>