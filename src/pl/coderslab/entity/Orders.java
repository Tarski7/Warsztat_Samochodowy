package pl.coderslab.entity;

public class Orders {

	private int id;
	private String dateOfAcceptanceForRepair;
	private String plannedDateOfStartRepair;
	private String dateOfStartRepair;
	private String descriptionOfTheProblem;
	private String descriptionOfTheRepair;
	private int status = 0;
	private double costOfRepair;
	private double costOfUsedParts;
	private double costOfOperatingHourOfEmployee;
	private int numberOfOperatingHours;
	private int employee_id;
	private int vehicle_id;
	
	
	
	
	
	public Orders(int id, String dateOfAcceptanceForRepair, String plannedDateOfStartRepair, String dateOfStartRepair,
			String descriptionOfTheProblem, String descriptionOfTheRepair, int status, double costOfRepair,
			double costOfUsedParts, double costOfOperatingHourOfEmployee, int numberOfOperatingHours, int employee_id,
			int vehicle_id) {
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
		this.employee_id = employee_id;
		this.vehicle_id = vehicle_id;
	}


	public Orders() {
		
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


	public int getStatus() {
		return status;
	}


	//Status setter with validation
	public void setStatus(int status) {
		if (status > 0 && status < 6)
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


	public int getEmployee_id() {
		return employee_id;
	}


	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}


	public int getVehicle_id() {
		return vehicle_id;
	}


	public void setVehicle_id(int vehicle_id) {
		this.vehicle_id = vehicle_id;
	}
	
}
	
	