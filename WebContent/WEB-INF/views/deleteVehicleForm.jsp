<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete vehicle</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<h1>Delete Employee</h1>
	
	<form action="" method="POST">
  		<div class="form-group col-lg-3">
		    <label for="inputId">Enter id to delete vehicle</label>
		    <input type="number" min="0.00" step="1" name="vehicleId" class="form-control" id="InputId" placeholder="Enter ID">
		    <small id="idHelp" class="form-text text-muted">We'll never share your personal data with anyone else.</small>
  		</div>
  		<div class="col-lg-10">
		    <button type="submit" class="btn btn-primary">Submit</button>
  		</div>
  	</form>

</body>
</html>