<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of cutomers</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/js/bootstrap.min.js"></script>
</head>
<body>
	<form action="/Warsztat_samochodowy/LoadSearchedCustomers" method="GET">
    <div class="row">
	<div class="form-group col-lg-3">
    	<label for="inputLastName">Search customers by last name:</label>
    	<input type="text" class="form-control" id="inputLastName" name="lastName" placeholder="Enter last name">
    	<button type="submit" class="btn btn-primary">Search</button>
  	</div>
	</form>
	<table class="table table-inverse table-border">
	  	<thead>
	    	<tr>
		      <th>#</th>
		      <th>id</th>
		      <th>Name</th>
		      <th>Last Name</th>
		      <th>Date of birth</th> 
		      <th>Show customer's cars</th>
		      <th>Edit</th>
		      <th>Delete</th>
	    	</tr>
	  	</thead>
	  	<tbody>
	  		<c:forEach items="${ customers }" begin="0" step="1" varStatus="theCount" var="customer">
	    		<tr>
				   <th scope="row">${theCount.count}</th>
				   <td>${customer.id}</td>
				   <td>${customer.name}</td>
				   <td>${customer.lastName}</td>
				   <td>${customer.dateOfBirth}</td>
				   <td>
					<form action="http://localhost:8080/Warsztat_samochodowy/LoadCustomerCars" method="GET">
				   <button type="submit" class="btn btn-primary" name="id" value="${customer.id}">Show cars</button></form>
					</td>
				   <td>
				   <form action="http://localhost:8080/Warsztat_samochodowy/UpdateCustomerFormLauncher" method="POST">
				   <button type="submit" class="btn btn-primary" name="idToEdit" value="${customer.id}">Edit</button></form>
				   </td>
				   <td>
				   <form action="http://localhost:8080/Warsztat_samochodowy/DeleteCustomer" method="POST">
				   <button type="submit" class="btn btn-primary" name="idToDelete" value="${customer.id}">Delete</button></form>
				   </td>
	    		</tr>
	    	</c:forEach>
	  	</tbody>
	</table>
	<a href="http://localhost:8080/Warsztat_samochodowy/LoadAllCustomers" class="btn btn-primary active" role="button" aria-pressed="true">Show all customers</a>
	<a href="http://localhost:8080/Warsztat_samochodowy/AddCustomer" class="btn btn-primary active" role="button" aria-pressed="true">Add new customer</a>
	<a href="http://localhost:8080/Warsztat_samochodowy/LoadCurrentRepairs" class="btn btn-primary active" role="button" aria-pressed="true">Go back to main menu</a>
</body>
</html>