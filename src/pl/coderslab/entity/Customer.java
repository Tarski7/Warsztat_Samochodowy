package pl.coderslab.entity;

public class Client {
	
	private int id;
	private String name;
	private String lastName;
	private String birthDate;
	
	public Client() {
		
	}
	
	public Client(int id, String name, String lastName, String birthDate) {
		super();
		setName(name);
		setLastName(lastName);
		setBirthDate(birthDate);
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
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	
	
}
