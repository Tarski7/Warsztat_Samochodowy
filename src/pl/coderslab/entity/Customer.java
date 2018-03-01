package pl.coderslab.entity;


import java.util.Date;


public class Customer {

	private int id;
	private String name = "";
	private String lastName = "";
	private String dateOfBirth = null;

	public Customer() {

	}

	public Customer(int id, String name, String lastName, String dateOfBirth) {
		super();
		setId(id);
		setName(name);
		setLastName(lastName);
		setDateOfBirth(dateOfBirth);
	}

	public void setId(int id) {
		this.id = id;
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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {

		// TODO:: date format validation

		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth
				+ "]";
	}

	

}


