<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Report</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<h3>Enter date of report</h3>

	<form action="" method="POST">
	    <div class="row">
	  	<div class="form-group col-lg-3">
		    <label for="inputDateFrom">Date from</label>
		    <input type="date" class="form-control" id="inputDateFrom" name="dateFrom" placeholder="Enter date from">
		    <small id="dateFromHelp" class="form-text text-muted">We'll never share your personal data with anyone else.</small>
	  	</div>
	  	</div>
	  
	  	<div class="row">
	  	<div class="form-group col-lg-3">
		    <label for="inputDateTo">Date to</label>
		    <input type="date" class="form-control" id="inputDateTo" name="dateTo" placeholder="Enter date to">
		    <small id="dateToHelp" class="form-text text-muted">We'll never share your personal data with anyone else.</small>
	  	</div>
	  	</div>
	  	<button type="submit" class="btn btn-primary">Submit</button>
	</form>

</body>
</html>