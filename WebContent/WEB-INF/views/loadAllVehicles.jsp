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
		      <th>#</th>
		      <th>id</th>
		      <th>Model</th>
		      <th>Brand</th>
		      <th>Year of production</th>
		      <th>Registration number</th>
		      <th>Date of next technical inspection</th>
		      <th>Customer id</th>     
	    	</tr>
	  	</thead>
	  	<tbody>
	  		<c:forEach items="${ vehicles }" begin="0" step="1" varStatus="theCount" var="vehicle">
	    		<tr>
				   <th scope="row">${theCount.count}</th>
				   <td>${vehicle.id}</td>
				   <td>${vehicle.model}</td>
				   <td>${vehicle.brand}</td>
				   <td>${vehicle.yearOfProduction}</td>
				   <td>${vehicle.registrationNumber}</td>
				   <td>${vehicle.dateOfNextTechnicalInspection}</td>
				   <td>${vehicle.customerId}</td>
	    		</tr>
	    	</c:forEach>
	  	</tbody>
	</table>

</body>
</html>