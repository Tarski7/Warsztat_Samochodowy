package pl.coderslab.entity;

import java.util.Date;

public class Vehicle {
	
	private int id;
	private String model;
	private String brand;
	private Date yearOfProduction;
	private String registrationNumber;
	private Date dateOfNextTechnicalInspection;
	private int client_id;
	
	public Vehicle() {
		super();
	}
	public Vehicle(String model, String brand, Date yearOfProduction, String registrationNumber,
			Date dateOfNextTechnicalInspection, int client_id) {
		super();
		this.model = model;
		this.brand = brand;
		this.yearOfProduction = yearOfProduction;
		this.registrationNumber = registrationNumber;
		this.dateOfNextTechnicalInspection = dateOfNextTechnicalInspection;
		this.client_id = client_id;
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
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", model=" + model + ", brand=" + brand + ", yearOfProduction=" + yearOfProduction
				+ ", registrationNumber=" + registrationNumber + ", dateOfNextTechnicalInspection="
				+ dateOfNextTechnicalInspection + ", client_id=" + client_id + "]";
	}
	
}
