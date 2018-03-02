<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Vehicle</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<h3>Update Vehicle</h3>

<form action="" method="POST">
    <div class="row">
	<div class="form-group col-lg-3">
    	<label for="inputModel">Model</label>
    	<input type="text" class="form-control" id="inputModel" name="model" value="${vehicle.model}">
    	<small id="modelHelp" class="form-text text-muted">We'll never share your personal data with anyone else.</small>
  	</div>
  	</div>
  	<div class="row">
	<div class="form-group col-lg-3">
	    <label for="inputBrand">Brand</label>
	    <input type="text" class="form-control" id="inputBrand" name="brand" value="${vehicle.brand}">
	    <small id="brandHelp" class="form-text text-muted">We'll never share your personal data with anyone else.</small>
  	</div>
  	</div>
  	<div class="row">
  	<div class="form-group col-lg-3">
	    <label for="inputYearOfProduction">Year of production</label>
	    <input type="date" class="form-control" id="inputYearOfProduction" name="yearOfProduction" value="${vehicle.yearOfProduction}">
	    <small id="yearOfProductionHelp" class="form-text text-muted">We'll never share your personal data with anyone else.</small>
  	</div>
  	</div>
  	<div class="row">
  	<div class="form-group col-lg-3">
	    <label for="inputRegistrationNumber">Registration number</label>
	    <input type="text" class="form-control" id="inputRegistrationNumber" name="registrationNumber" value="${vehicle.registrationNumber}">
	    <small id="registrationNumberHelp" class="form-text text-muted">We'll never share your personal data with anyone else.</small>
  	</div>
  	</div>
  	<div class="row">
  	 <div class="form-group col-lg-3">
	    <label for="inputNote">Date of next technical inspection</label>
	    <input type="date" class="form-control" id="inputDateOfNextTechnicalInspection" name="dateOfNextTechnicalInspection" value="${vehicle.dateOfNextTechnicalInspection}"></input>
	    <small id="dateOfNextTechnicalInspectionHelp" class="form-text text-muted">We'll never share your personal data with anyone else.</small>
  	</div>
  	</div>
  	<div class="row">
  	<div class="form-group col-lg-3">
	    <label for="inputCustomerId">Customer id</label>
	    <input type="text" class="form-control" id="inputCustomerId" name="customerId" value="${vehicle.customerId}">
	    <small id="customerIdHelp" class="form-text text-muted">We'll never share your personal data with anyone else.</small>
  	</div>
  	</div>
  	<input type="hidden" name="id" value="${vehicle.id}">
  	<button type="submit" class="btn btn-primary">Submit</button>
</form>

</body>
</html>