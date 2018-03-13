<%@ include file="WEB-INF/views/header.jspf" %>

<%@ include file="WEB-INF/views/navCard.jspf" %>

<table class="table table-inverse table-border">
	  	<thead>
	    	<tr>
		      <th>id</th>
		      <th>Date of acceptance for repair</th>
		      <th>Planned date of repair start</th>
		      <th>Date of repair start</th> 
		      <th>Description of the problem</th>
		      <th>Description of the repair</th>
		      <th>Status</th>
		      <th>Cost of repair</th>
		      <th>Cost of used parts</th>
		      <th>Cost of man-hour of an employee</th>
		      <th>Number of man-hours that the repair took</th>
		      <th>Employee id</th>
		      <th>Vehicle id</th>
	    	</tr>
	  	</thead>
	  	<tbody>
	  		<c:forEach items="${ employeeRepairs }" begin="0" step="1" varStatus="theCount" var="repair">
	    		<tr>
				   <td>${repair.id}</td>
				   <td>${repair.dateOfAcceptanceForRepair}</td>
				   <td>${repair.plannedDateOfStartRepair}</td>
				   <td>${repair.dateOfStartRepair}</td>
				   <td>${repair.descriptionOfTheProblem}</td>
				   <td>${repair.descriptionOfTheRepair}</td>
				   <td>${repair.status}</td>
				   <td>${repair.costOfRepair}</td>
				   <td>${repair.costOfUsedParts}</td>
				   <td>${repair.costOfOperatingHourOfEmployee}</td>
				   <td>${repair.numberOfOperatingHours}</td>
				   <td>${repair.employeeId}</td>
				   <td>${repair.vehicleId}</td>
				   <td><form action="/Warsztat_samochodowy/UpdateOrder" method="GET">
  						<button type="submit" name="idToEdit" value="${repair.id}" class="btn-link">Edit</button>
						</form>
						<form action="/Warsztat_samochodowy/DeleteOrder" method="POST">
  						<button type="submit" name="idToDelete" value="${repair.id}" class="btn-link">Delete</button>
						</form></td>
	    		</tr>
	    	</c:forEach>
	  	</tbody>
	</table>

<%@ include file="WEB-INF/views/footer.jspf" %>

