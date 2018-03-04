package pl.coderslab.entity;

import java.util.Date;

public class Vehicle {
	
	private int id;
	private String model;
	private String brand;
	private Date yearOfProduction;
	private String registrationNumber;
	private Date dateOfNextTechnicalInspection;
	private int customerId;
	
	public Vehicle() {
		super();
	}
	
	public Vehicle(String model, String brand, Date yearOfProduction, String registrationNumber,
			Date dateOfNextTechnicalInspection, int customerId) {
		super();
		this.model = model;
		this.brand = brand;
		this.yearOfProduction = yearOfProduction;
		this.registrationNumber = registrationNumber;
		this.dateOfNextTechnicalInspection = dateOfNextTechnicalInspection;
		this.customerId = customerId;
	}
	
	//Constructor needed to show cars of a chosen customer
	public Vehicle(int id, String model, String brand, Date yearOfProduction, String registrationNumber,
			Date dateOfNextTechnicalInspection) {
		super();
		setId(id);
		setModel(model);
		setBrand(brand);
		setYearOfProduction(yearOfProduction);
		setRegistrationNumber(registrationNumber);
		setDateOfNextTechnicalInspection(dateOfNextTechnicalInspection);
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Date getYearOfProduction() {
		return yearOfProduction;
	}
	public void setYearOfProduction(Date yearOfProduction) {
		this.yearOfProduction = yearOfProduction;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public Date getDateOfNextTechnicalInspection() {
		return dateOfNextTechnicalInspection;
	}
	public void setDateOfNextTechnicalInspection(Date dateOfNextTechnicalInspection) {
		this.dateOfNextTechnicalInspection = dateOfNextTechnicalInspection;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", model=" + model + ", brand=" + brand + ", yearOfProduction=" + yearOfProduction
				+ ", registrationNumber=" + registrationNumber + ", dateOfNextTechnicalInspection="
				+ dateOfNextTechnicalInspection + ", customerId=" + customerId + "]";
	}
	
}
