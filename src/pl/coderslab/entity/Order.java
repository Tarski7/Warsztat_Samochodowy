package pl.coderslab.entity;

public class Order {

	private int id;
	private String dateOfAcceptanceForRepair;
	private String plannedDateOfStartRepair;
	private String dateOfStartRepair;
	private String descriptionOfTheProblem;
	private String descriptionOfTheRepair;
	private String status = "";
	private double costOfRepair;
	private double costOfUsedParts;
	private double costOfOperatingHourOfEmployee;
	private int numberOfOperatingHours;
	private int employeeId;
	private int vehicleId;
	
	
	
	
	
	public Order(int id, String dateOfAcceptanceForRepair, String plannedDateOfStartRepair, String dateOfStartRepair,
			String descriptionOfTheProblem, String descriptionOfTheRepair, String status, double costOfRepair,
			double costOfUsedParts, double costOfOperatingHourOfEmployee, int numberOfOperatingHours, int employeeId,
			int vehicleId) {
		super();
		this.id = id;
		this.dateOfAcceptanceForRepair = dateOfAcceptanceForRepair;
		this.plannedDateOfStartRepair = plannedDateOfStartRepair;
		this.dateOfStartRepair = dateOfStartRepair;
		this.descriptionOfTheProblem = descriptionOfTheProblem;
		this.descriptionOfTheRepair = descriptionOfTheRepair;
		setStatus(status);
		this.costOfRepair = costOfRepair;
		this.costOfUsedParts = costOfUsedParts;
		this.costOfOperatingHourOfEmployee = costOfOperatingHourOfEmployee;
		this.numberOfOperatingHours = numberOfOperatingHours;
		this.employeeId = employeeId;
		this.vehicleId = vehicleId;
	}

	public Order(int id, String dateOfAcceptanceForRepair, String plannedDateOfStartRepair, String dateOfStartRepair,
			String descriptionOfTheProblem, String descriptionOfTheRepair, String status, double costOfRepair,
			double costOfUsedParts, double costOfOperatingHourOfEmployee, int numberOfOperatingHours,
			int vehicleId) {
		super();
		this.id = id;
		this.dateOfAcceptanceForRepair = dateOfAcceptanceForRepair;
		this.plannedDateOfStartRepair = plannedDateOfStartRepair;
		this.dateOfStartRepair = dateOfStartRepair;
		this.descriptionOfTheProblem = descriptionOfTheProblem;
		this.descriptionOfTheRepair = descriptionOfTheRepair;
		setStatus(status);
		this.costOfRepair = costOfRepair;
		this.costOfUsedParts = costOfUsedParts;
		this.costOfOperatingHourOfEmployee = costOfOperatingHourOfEmployee;
		this.numberOfOperatingHours = numberOfOperatingHours;
		this.vehicleId = vehicleId;
	}

	public Order() {
		
	}


	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}


	public String getDateOfAcceptanceForRepair() {
		return dateOfAcceptanceForRepair;
	}


	public void setDateOfAcceptanceForRepair(String dateOfAcceptanceForRepair) {
		this.dateOfAcceptanceForRepair = dateOfAcceptanceForRepair;
	}


	public String getPlannedDateOfStartRepair() {
		return plannedDateOfStartRepair;
	}


	public void setPlannedDateOfStartRepair(String plannedDateOfStartRepair) {
		this.plannedDateOfStartRepair = plannedDateOfStartRepair;
	}


	public String getDateOfStartRepair() {
		return dateOfStartRepair;
	}


	public void setDateOfStartRepair(String dateOfStartRepair) {
		this.dateOfStartRepair = dateOfStartRepair;
	}


	public String getDescriptionOfTheProblem() {
		return descriptionOfTheProblem;
	}


	public void setDescriptionOfTheProblem(String descriptionOfTheProblem) {
		this.descriptionOfTheProblem = descriptionOfTheProblem;
	}


	public String getDescriptionOfTheRepair() {
		return descriptionOfTheRepair;
	}


	public void setDescriptionOfTheRepair(String descriptionOfTheRepair) {
		this.descriptionOfTheRepair = descriptionOfTheRepair;
	}


	public String getStatus() {
		return status;
	}


	//Status setter with validation
	public void setStatus(String status) {
		this.status = status;
	}


	public double getCostOfRepair() {
		return costOfRepair;
	}


	public void setCostOfRepair(double costOfRepair) {
		this.costOfRepair = costOfRepair;
	}


	public double getCostOfUsedParts() {
		return costOfUsedParts;
	}


	public void setCostOfUsedParts(double costOfUsedParts) {
		this.costOfUsedParts = costOfUsedParts;
	}


	public double getCostOfOperatingHourOfEmployee() {
		return costOfOperatingHourOfEmployee;
	}


	public void setCostOfOperatingHourOfEmployee(double costOfOperatingHourOfEmployee) {
		this.costOfOperatingHourOfEmployee = costOfOperatingHourOfEmployee;
	}


	public int getNumberOfOperatingHours() {
		return numberOfOperatingHours;
	}


	public void setNumberOfOperatingHours(int numberOfOperaingHours) {
		this.numberOfOperatingHours = numberOfOperaingHours;
	}


	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


	public int getVehicleId() {
		return vehicleId;
	}


	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	
}
	
	