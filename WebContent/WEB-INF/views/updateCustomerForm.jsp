<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Update the customer data</h3>
	<h5>Leave the field blank if you do not want to update the value</h5>
	<form action="/Warsztat_Samochodowy/UpdateCustomer" method="POST">
		Insert new name:
		<input type="text" name="newName"><br>
		Insert new last name:
		<input type="text" name="newLastName"><br>
		Insert new date of birth (yyyy-dd-mm):
		<input type="text" name="newDateOfBirth"><br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>