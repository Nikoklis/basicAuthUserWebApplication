<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Login Page</title>
	<link rel="stylesheet" type="text/css" href="globalStyle.css">
	
</head>
<body>
	
	<div class="box">
		<form id="mainForm" action="" method="POST">
		
				
				<input class="email" type="email" name="email" placeholder="email"/>
				
				<input class="password" type="password" name="password" placeholder="password"/>
				
				
				
				<div class="error">${userNotExist}</div>
				<br>
				<div class="buttons">
					<input id="signIn" type="button" name="SignIn" value="Sign in" onclick="askForSignIn()">
					<input id="signUp" type="button" name="SignUp" value="Sign up" onclick="askForSignUp()">
				</div>
				
		</form>
		
			
	</div>
	
	<script src="buttonActions.js"></script>
	
</body>
</html>