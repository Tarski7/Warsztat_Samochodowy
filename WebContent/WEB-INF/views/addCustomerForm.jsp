<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Add new customer</title>
</head>
<body>
	<form action="" method="POST" class="form-horizontal">
		<fieldset>


			<!-- change col-sm-N to reflect how you would like your column spacing (http://getbootstrap.com/css/#forms-control-sizes) -->


			<!-- Form Name -->
			<legend>Add a new customer</legend>

			<!-- Text input http://getbootstrap.com/css/#forms -->
			<div class="form-group">
				<label for="name" class="control-label col-sm-2">Name</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="name" name="name" placeholder="Enter name" required="">
				</div>
			</div>
			<!-- Text input http://getbootstrap.com/css/#forms -->
			<div class="form-group">
				<label for="lastName" class="control-label col-sm-2">Surname</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="lastName" name="lastName" placeholder="Enter surname" required="">
				</div>
			</div>
			<!-- Text input http://getbootstrap.com/css/#forms -->
			<div class="form-group">
				<label for="dateOfBirth" class="control-label col-sm-2">Date
					of birth</label>
				<div class="col-sm-10">
					<input type="date" class="form-control" id="dateOfBirth" name="dateOfBirth" placeholder="YYYY-MM-DD">
				</div>
			</div>
			<!-- Button http://getbootstrap.com/css/#buttons -->
			<div class="form-group">
				<label class="control-label col-sm-2" for="singlebutton"></label>
				<div class="text-right col-sm-10">
					<button type="submit" class="btn btn-primary">Submit</button>
				</div>
			</div>


		</fieldset>
	</form>


	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</body>
</html>

