<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Employee</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<h3>Update Employee</h3>

<form action="" method="POST">
    <div class="row">
	<div class="form-group col-lg-3">
    	<label for="inputName">Name</label>
    	<input type="text" class="form-control" id="inputName" name="name" value="${employee.name}">
    	<small id="nameHelp" class="form-text text-muted">We'll never share your personal data with anyone else.</small>
  	</div>
  	</div>
  	<div class="row">
	<div class="form-group col-lg-3">
	    <label for="inputSurname">Surname</label>
	    <input type="text" class="form-control" id="inputSurname" name="surname" value="${employee.surname}">
	    <small id="surnameHelp" class="form-text text-muted">We'll never share your personal data with anyone else.</small>
  	</div>
  	</div>
  	<div class="row">
  	<div class="form-group col-lg-3">
	    <label for="inputAddress">Address</label>
	    <input type="text" class="form-control" id="inputAddress" name="address" value="${employee.address}">
	    <small id="addressHelp" class="form-text text-muted">We'll never share your personal data with anyone else.</small>
  	</div>
  	</div>
  	<div class="row">
  	<div class="form-group col-lg-3">
	    <label for="inputPhoneNumber">Phone number</label>
	    <input type="text" class="form-control" id="inputPhoneNumber" name="phoneNumber" value="${employee.phoneNumber}">
	    <small id="phoneNumberHelp" class="form-text text-muted">We'll never share your personal data with anyone else.</small>
  	</div>
  	</div>
  	<div class="row">
  	 <div class="form-group col-lg-3">
	    <label for="inputNote">Note</label>
	    <textarea class="form-control" id="inputNote" rows="2" name="note" value="${employee.note}"></textarea>
	    <small id="noteHelp" class="form-text text-muted">We'll never share your personal data with anyone else.</small>
  	</div>
  	</div>
  	<div class="row">
  	<div class="form-group col-lg-3">
	    <label for="inputCostOfOperatingHour">Cost of operating hour</label>
	    <input type="number" min="0.00" step="0.01" class="form-control" id="inputCostOfOperatingHour" name="costOfOperatingHour" value="${employee.costOfOperatingHour}">
	    <small id="costOfOperatingHourHelp" class="form-text text-muted">We'll never share your personal data with anyone else.</small>
  	</div>
  	</div>
  	<input type="hidden" name="id" value="${employee.id}">
  	<button type="submit" class="btn btn-primary">Submit</button>
</form>

</body>
</html>