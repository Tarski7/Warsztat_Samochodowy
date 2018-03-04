<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of customer's cars</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/js/bootstrap.min.js"></script>
</head>
<body>

	<table class="table table-inverse table-border">
	  	<thead>
	    	<tr>
		      <th>Date of repair start</th>
		      <th>Description of the repair</th> 
	    	</tr>
	  	</thead>
	  	<tbody>
	  		<c:forEach items="${ repairHistory }" begin="0" step="1" varStatus="theCount" var="repairHistory">
	    		<tr>
				   <td>${repairHistory.dateOfStartRepair}</td>
				   <td>${repairHistory.descriptionOfTheRepair}</td>
				   <td><form action="http://localhost:8080/Warsztat_samochodowy/LoadDetailsOfOrder" method="get">
				   <button type="submit" class="btn btn-primary" name="id" value="${repairHistory.id}">Show details</button></form></td>
	    		</tr>
	    	</c:forEach>
	  	</tbody>
	</table>
	
	<a href="http://localhost:8080/Warsztat_samochodowy/AddVehicle" class="btn btn-primary active" role="button" aria-pressed="true">Add new Vehicle</a>
	<a href="http://localhost:8080/Warsztat_samochodowy/LoadAllCustomers" class="btn btn-primary active" role="button" aria-pressed="true">Go back to Customers</a>

</body>
</html>