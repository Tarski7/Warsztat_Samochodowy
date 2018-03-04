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

<h3>You are updating order no. ${order.id}</h3>

<form action="" method="POST">
    <div class="row">
	<div class="form-group col-lg-3">
    	<label for="inputDateOfAcceptanceForRepair">Date of acceptance for repair</label>
    	<input type="date" class="form-control" id="inputDateOfAcceptanceForRepair" name="dateOfAcceptanceForRepair" value="${order.dateOfAcceptanceForRepair}">
    	<small id="dateOfAcceptanceForRepairHelp" class="form-text text-muted">We'll never share your personal data with anyone else.</small>
  	</div>
  	</div>
  	<div class="row">
	<div class="form-group col-lg-3">
	    <label for="inputPlannedDateOfStartRepair">Planned date of start repair</label>
	    <input type="date" class="form-control" id="inputPlannedDateOfStartRepair" name="plannedDateOfStartRepair" value="${order.plannedDateOfStartRepair}">
	    <small id="plannedDateOfStartRepairHelp" class="form-text text-muted">We'll never share your personal data with anyone else.</small>
  	</div>
  	</div>
  	<div class="row">
  	<div class="form-group col-lg-3">
	    <label for="inputDateOfStartRepair">Date of start repair</label>
	    <input type="date" class="form-control" id="inputDateOfStartRepair" name="dateOfStartRepair" value="${order.dateOfStartRepair}">
	    <small id="dateOfStartRepairHelp" class="form-text text-muted">We'll never share your personal data with anyone else.</small>
  	</div>
  	</div>
  	<div class="row">
  	<div class="form-group col-lg-3">
	    <label for="inputDescriptionOfTheProblem">Description of the problem</label>
	    <textarea class="form-control" id="inputDescriptionOfTheProblem" rows="2" name="descriptionOfTheProblem" value="${order.descriptionOfTheProblem}"></textarea>
	    <small id="descriptionOfTheProblemHelp" class="form-text text-muted">We'll never share your personal data with anyone else.</small>
  	</div>
  	</div>
  	<div class="row">
  	 <div class="form-group col-lg-3">
	    <label for="inputDescriptionOfTheRepair">Description of the repair</label>
	    <textarea class="form-control" id="inputDescriptionOfTheRepair" rows="2" name="descriptionOfTheRepair" value="${order.descriptionOfTheRepair}"></textarea>
	    <small id="descriptionOfTheRepairHelp" class="form-text text-muted">We'll never share your personal data with anyone else.</small>
  	</div>
  	</div>
  	<div class="row">
  	<div class="form-group col-lg-3">
    	<div class="form-group">
     		<label for="inputStatus">Select status:</label>
      			<select class="form-control" id="inputStatus" name="status" value="${order.status}">
        			<option value="Accepted">Accepted</option>
		        	<option value="Confirmed repair costs">Confirmed repair costs</option>
		        	<option value="In repair">In repair</option>
		       	 	<option value="Ready for pickup">Ready for pickup</option>
		        	<option value="Resignation">Resignation</option>
      			</select>
		</div>
	    <small id="statusHelp" class="form-text text-muted">We'll never share your personal data with anyone else.</small>
  	</div>
  	</div>
  	<div class="row">
  	<div class="form-group col-lg-3">
	    <label for="inputCostOfRepair">Cost of repair</label>
	    <input type="number" min="0.00" step="0.01" class="form-control" id="inputCostOfRepair" name="costOfRepair" value="${order.costOfRepair}">
	    <small id="costOfRepairHelp" class="form-text text-muted">We'll never share your personal data with anyone else.</small>
  	</div>
  	</div>
  	<div class="row">
  	<div class="form-group col-lg-3">
	    <label for="inputCostOfUsedParts">Cost of used parts</label>
	    <input type="number" min="0.00" step="0.01" class="form-control" id="inputCostOfUsedParts" name="costOfUsedParts" value="${order.costOfUsedParts}">
	    <small id="costOfUsedPartsHelp" class="form-text text-muted">We'll never share your personal data with anyone else.</small>
  	</div>
  	</div>
  	<div class="row">
  	<div class="form-group col-lg-3">
	    <label for="inputCostOfOperatingHourOfEmployee">Cost of operating hour of employee</label>
	    <input type="number" min="0.00" step="0.01" class="form-control" id="inputCostOfOperatingHourOfEmployee" name="costOfOperatingHourOfEmployee" value="${order.costOfOperatingHourOfEmployee}">
	    <small id="costOfOperatingHourOfEmployeeHelp" class="form-text text-muted">We'll never share your personal data with anyone else.</small>
  	</div>
  	</div>
  	<div class="row">
  	<div class="form-group col-lg-3">
	    <label for="inputNumberOfOperatingHours">Number of operating hours</label>
	    <input type="number" min="0" step="1" class="form-control" id="inputNumberOfOperatingHours" name="numberOfOperatingHours" value="${order.numberOfOperatingHours}">
	    <small id="numberOfOperatingHoursHelp" class="form-text text-muted">We'll never share your personal data with anyone else.</small>
  	</div>
  	</div>
  	<div class="row">
  	<div class="form-group col-lg-3">
	    <label for="inputEmployeeId">Employee id</label>
	    <input type="number" min="0" step="1" class="form-control" id="inputEmployeeId" name="employeeId" value="${order.employeeId}">
	    <small id="employeeIdHelp" class="form-text text-muted">We'll never share your personal data with anyone else.</small>
  	</div>
  	</div>
  	<div class="row">
  	<div class="form-group col-lg-3">
	    <label for="inputVehicleId">Vehicle id</label>
	    <input type="number" min="0" step="1" class="form-control" id="inputVehicleId" name="vehicleId" value="${order.vehicleId}">
	    <small id="vehicleIdHelp" class="form-text text-muted">We'll never share your personal data with anyone else.</small>
  	</div>
  	</div>
  	<button type="submit" class="btn btn-primary">Submit</button>
</form>

</body>
</html>