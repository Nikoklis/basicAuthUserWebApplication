

function askForSignIn() {
	mainForm=document.getElementById("mainForm");
	mainForm.action = "checkUser";
	mainForm.submit();
}
function askForSignUp() {
	window.location.href = "Register";
}

function registerUser(){
	registerForm = document.getElementById("registerForm");
	registerForm.action="AddUser";
	registerForm.submit();
}

function goBack() {
	registerForm = document.getElementById("registerForm");
	registerForm.action="Login";
	registerForm.submit();
}

function EditFunc(){
	updateForm = document.getElementById("updateForm");
	updateForm.action="UpdateUser";
	updateForm.submit();
}

function DisconnectFunc(){
	updateForm = document.getElementById("updateForm");
	updateForm.action="Disconnect";
	updateForm.submit();
}