<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of employees</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/js/bootstrap.min.js"></script>
</head>
<body>

	<table class="table table-inverse table-border">
	  	<thead>
	    	<tr>
		      <th>id</th>
		      <th>Name</th>
		      <th>Surname</th>
		      <th>Address</th>
		      <th>Phone number</th>
		      <th>Note</th>
		      <th>Cost of operating hour</th>   
	    	</tr>
	  	</thead>
	  	<tbody>
	  		<tr>
				<td>${employee.id}</td>
				<td>${employee.name}</td>
				<td>${employee.surname}</td>
 				<td>${employee.address}</td>
 				<td>${employee.phoneNumber}</td>
				<td>${employee.note}</td>
	 			<td>${employee.costOfOperatingHour}</td>
	 			</tr>	   
	  	</tbody>
	</table>
	
	<a href="http://localhost:8080/Warsztat_Samochodowy/LoadAllEmployees" class="btn btn-primary active" role="button" aria-pressed="true">Go back to employees</a>
	<a href="http://localhost:8080/Warsztat_Samochodowy/index.jsp" class="btn btn-primary active" role="button" aria-pressed="true">Go back to main menu</a>
	
</body>
</html>