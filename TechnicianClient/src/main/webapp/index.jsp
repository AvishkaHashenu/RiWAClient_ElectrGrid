<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
if (session.getAttribute("Username") != null) 
 { 
 response.sendRedirect("technicians.jsp"); 
 } 
%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Login</title>
	<link rel="stylesheet" href="Views/bootstrap.min.css">
	<link rel="stylesheet" href="Views/index.css">
	<script src="Components/jquery.min.js"></script>
	<script src="Components/auth.js"></script>
</head>
<body>
	<header>
		<h1>ElectroGrid Online Platform</h1>
	</header>
	<div class="container" style="margin-left: 500px">
	<div class="row">
	<div class="col-6" style="margin-top: 350px;">
	<h1>Login</h1>
	<form id="formLogin" style="margin-top: 20px; background-color: #EAEAEA; padding: 15px; font-size: 17px;">
 	UserName: 
 	<input id="txtUsername" name="txtUsername" type="text" class="form-control form-control-sm">
 	<br>
 	Password: 
 	<input id="txtPassword" name="txtPassword" type="password" class="form-control form-control-sm">
 	<br>
 	<input id="btnLogin" name="btnLogin" type="button" value="Login" class="btn btn-primary">
 	<br>
 	<br>
 	<div id="alertError" class="alert alert-danger"></div>
	</form>
 	</div>
	</div>
	</div>
</body>
</html>