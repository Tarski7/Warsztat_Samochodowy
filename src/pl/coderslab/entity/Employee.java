package pl.coderslab.entity;

public class Employee {

	private int id = 0;
	private String name = "";
	private String surname = "";
	private String address = "";
	private int phoneNumber;
	private String note = "";
	private double costOfOperatingHour = 0;
	
	public Employee() {
		super();
	}

	public Employee(String name, String surname, String address, int phoneNumber, String note, double costOfOperatingHour) {
		super();
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.note = note;
		this.costOfOperatingHour = costOfOperatingHour;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public double getCostOfOperatingHour() {
		return costOfOperatingHour;
	}

	public void setCostOfOperatingHour(double costOfOperatingHour) {
		this.costOfOperatingHour = costOfOperatingHour;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", surname=" + surname + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + ", note=" + note + ", costOfOperatingHour=" + costOfOperatingHour + "]";
	}
	
}
