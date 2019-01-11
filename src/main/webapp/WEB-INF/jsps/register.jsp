<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="globalStyle.css">
<link rel="stylesheet" type="text/css" href="registerStyle.css">

</head>
<body>
	<div style="top:0%;height:100%;margin:0;overflow:auto" class="box">
		<h1 style="text-align:center;">Sign Up</h1>
		
		<p style="text-align:center;">Please fill in this form to create an account.</p>
		<hr>
		
		
		<form:form id="registerForm" action="" method="post" modelAttribute="user">
		
			<form:errors path = "*" element = "div" style="color:red;background-color:FFBABA;"/>
			
			<div style="color:red;background-color:FFBABA;">${emailExists}</div>
			
			<label><b>Firstname:</b></label>
			<input type="text" name="firstName"><br>
			
			<label><b>Lastname:</b></label>
			<input type="text" name="lastName"><br>
			
			<label><b>Email:</b></label>
			<input type="email" name="email" required><br>
			
			<label><b>Phone Number:</b></label>
			<input type="text" name="phoneNumber"><br>
			<label><b>Company:</b></label>
			<input type="text" name="companyName"><br>
			
			<label><b>Password:</b></label>
			
			<input type="password" name="password" required><br>
			
			
			<label><b>Verify Password:</b></label>
			<input type="password" name="verify" title="Password must be the same as above" required><br>
			
			<div class="buttons">
				<input id="Register" type="submit" value="Register" onclick="registerUser()">
				<input id="Cancel" type="submit" value="Cancel" onclick="goBack()">
			</div>
			
				
		</form:form>
		
	</div>
	<script src="buttonActions.js"></script>
</body>
</html>