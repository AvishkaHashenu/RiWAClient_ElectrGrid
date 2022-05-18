<%@page import="com.Technician"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<% if (session.getAttribute("Username") == null) {response.sendRedirect("index.jsp");} %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Technicians Management</title>
	<link rel="stylesheet" href="Views/bootstrap.min.css">
	<link rel="stylesheet" href="Views/technicians.css">
	<script src="Components/jquery.min.js"></script>
	<script src="Components/technicians.js"></script>
	<script src="Components/auth.js"></script>
</head>
<body>
	<div class="container">
	<button id="btnLogout" class="btn btn-success" id="btnLogout" style="box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);">LogOut</button>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-6">
				<h1>Technicians Management</h1>
				<br>
				<form id="formTechnician" name="formTechnician" >
				Technician Name: <input id="name" name="name" type="text" class="form-control form-control-sm"> <br>
				Technician Address: <input id="address" name="address" type="text" class="form-control form-control-sm"> <br>
				Technician Email: <input id="email" name="email" type="text" class="form-control form-control-sm"> <br>
				Technician Phone: <input id="phone" name="phone" type="text" class="form-control form-control-sm"> <br>
				Type: <input id="type" name="type" type="text" class="form-control form-control-sm"> <br>
				Contract Technician Salary: <input id="salary" name="salary" type="text" class="form-control form-control-sm"> <br>
				Hourly Technician HourlyWages: <input id="hourlywage" name="hourlywage" type="text" class="form-control form-control-sm"> <br>
				<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary">
				<input type="hidden"	id="hidItemIDSave" name="hidItemIDSave" value="">
				</form>
				<div id="alertSuccess" class="alert alert-success"></div>
				<div id="alertError" class="alert alert-danger"></div>
				<br>
			<div id="divItemsGrid">
		<% 
		Technician techObj = new Technician();
		out.print(techObj.readTechnicians());
		%>
		</div>
	</div>
	</div>
	</div>
</body>
</html>