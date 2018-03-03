<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of vehicles</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/js/bootstrap.min.js"></script>
</head>
<body>

	<table class="table table-inverse table-border">
	  	<thead>
	    	<tr>
		      <th>id</th>
		      <th>Model</th>
		      <th>Brand</th>
		      <th>Year of production</th>
		      <th>Registration number</th>
		      <th>Date of next technical inspection</th>
		      <th>Customer id</th>
		      <th>Delete</th>
		      <th>Edit</th>  
	    	</tr>
	  	</thead>
	  	<tbody>
	  		<c:forEach items="${ vehicles }" begin="0" step="1" varStatus="theCount" var="vehicle">
	    		<tr>
				   <td>${vehicle.id}</td>
				   <td>${vehicle.model}</td>
				   <td>${vehicle.brand}</td>
				   <td>${vehicle.yearOfProduction}</td>
				   <td>${vehicle.registrationNumber}</td>
				   <td>${vehicle.dateOfNextTechnicalInspection}</td>
				   <td>${vehicle.customerId}</td>
				   <td><form action="http://localhost:8080/Warsztat_Samochodowy/DeleteVehicle" method="post">
				   <button type="submit" class="btn btn-primary" name="vehicleId" value="${vehicle.id}">Delete</button></form></td>
 				   <td><form action="http://localhost:8080/Warsztat_Samochodowy/UpdateVehicle" method="get">
 				   <button type="submit" class="btn btn-primary" name="vehicleId" value="${vehicle.id}">Edit</button></form></td>
	    		</tr>
	    	</c:forEach>
	  	</tbody>
	</table>
	
	<a href="http://localhost:8080/Warsztat_Samochodowy/AddVehicle" class="btn btn-primary active" role="button" aria-pressed="true">Add new vehicle</a>
	<a href="http://localhost:8080/Warsztat_Samochodowy/index.jsp" class="btn btn-primary active" role="button" aria-pressed="true">Go back to main menu</a>

</body>
</html>