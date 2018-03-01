package pl.coderslab.entity;


import java.util.Date;


public class Customer {

	private int id;
	private String name;
	private String lastName;
	private Date dateOfBirth = null;

	public Customer() {

	}

	public Customer(int id, String name, String lastName, Date dateOfBirth) {
		super();
		setName(name);
		setLastName(lastName);
		setBirthDate(dateOfBirth);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return dateOfBirth;
	}

	public void setBirthDate(Date dateOfBirth) {

		// TODO:: date format validation

		this.dateOfBirth = dateOfBirth;
	}
}
