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
		      <th>#</th>
		      <th>id</th>
		      <th>Date of acceptance for repair</th>
		      <th>Planned date of repair start</th>
		      <th>Date of repair start</th> 
		      <th>Description of the problem</th>
		      <th>Description of the repair</th>
		      <th>Status</th>
		      <th>Cost of repair</th>
		      <th>Cost of used parts</th>
		      <th>Cost of man-hour of an employee</th>
		      <th>Number of man-hours that the repair took</th>
		      <th>Employee id</th>
		      <th>Vehicle id</th>
	    	</tr>
	  	</thead>
	  	<tbody>
	  		<c:forEach items="${ orders }" begin="0" step="1" varStatus="theCount" var="order">
	    		<tr>
				   <th scope="row">${theCount.count}</th>
				   <td>${order.id}</td>
				   <td>${order.dateOfAcceptanceForRepair}</td>
				   <td>${order.plannedDateOfStartRepair}</td>
				   <td>${order.dateOfStartRepair}</td>
				   <td>${order.descriptionOfTheProblem}</td>
				   <td>${order.descriptionOfTheRepair}</td>
				   <td>${order.status}</td>
				   <td>${order.costOfRepair}</td>
				   <td>${order.costOfUsedParts}</td>
				   <td>${order.costOfOperatingHourOfEmployee}</td>
				   <td>${order.numberOfOperatingHours}</td>
				   <td>${order.employeeId}</td>
				   <td>${order.vehicleId}</td>
				   <td><form action="/Warsztat_samochodowy/UpdateOrderForm" method="POST">
  						<button type="submit" name="idToEdit" value="${order.id}" class="btn-link">Edit</button>
						</form>
						<form action="/Warsztat_samochodowy/DeleteOrder" method="POST">
  						<button type="submit" name="idToDelete" value="${order.id}" class="btn-link">Delete</button>
						</form></td>
	    		</tr>
	    	</c:forEach>
	  	</tbody>
	</table>
</body>
</html>