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
 		      <th>More information</th>
 		      <th>Employee repairs</th>
 		      <th>Delete employee</th>
		      <th>Edit employee</th>
	    	</tr>
	  	</thead>
	  	<tbody>
	  		<c:forEach items="${ employees }" begin="0" step="1" varStatus="theCount" var="employee">
	    		<tr>
				   <td>${employee.id}</td>
				   <td>${employee.name}</td>
				   <td>${employee.surname}</td>
				   <td><form action="http://localhost:8080/Warsztat_Samochodowy/LoadEmployeeMoreInformation" method="post">
				   <button type="submit" class="btn btn-primary" name="employeeId" value="${employee.id}">More</button></form></td>
				   <td><form action="http://localhost:8080/Warsztat_Samochodowy/LoadEmployeeRepairs" method="post">
				   <button type="submit" class="btn btn-primary" name="employeeId" value="${employee.id}">Repairs</button></form></td>
				   <td><form action="http://localhost:8080/Warsztat_Samochodowy/DeleteEmployee" method="post">
				   <button type="submit" class="btn btn-primary" name="employeeId" value="${employee.id}">Delete</button></form></td>
 				   <td><form action="http://localhost:8080/Warsztat_Samochodowy/UpdateEmployee" method="get">
 				   <button type="submit" class="btn btn-primary" name="employeeId" value="${employee.id}">Edit</button></form></td>
	    		</tr>
	    	</c:forEach>
	  	</tbody>
	</table>
	
	<a href="http://localhost:8080/Warsztat_Samochodowy/AddEmployee" class="btn btn-primary active" role="button" aria-pressed="true">Add new employee</a>
	<a href="http://localhost:8080/Warsztat_Samochodowy/index.jsp" class="btn btn-primary active" role="button" aria-pressed="true">Go back to main menu</a>
	
</body>
</html>