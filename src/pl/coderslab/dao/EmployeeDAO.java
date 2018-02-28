package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pl.coderslab.entity.Employee;

public class EmployeeDAO {
	
	
	public static List<String> addEmployee(String name, String surname, String address, String phoneNumber, String note, String costOfOperatingHour) {
		
		List<String> employees = new ArrayList<>();
			
		employees.add(name);
		employees.add(surname);
		employees.add(address);
		employees.add(phoneNumber);
		employees.add(note);
		employees.add(costOfOperatingHour);
			
		return employees;
	}
		
	static public List<Employee> loadAll() {
		
		List<Employee> employees = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11223305?useSSL=false", "sql11223305", "Tt1GjmaCpL")) {
			
			PreparedStatement query = conn.prepareStatement("SELECT * FROM EMPLOYEE");
			ResultSet rs = query.executeQuery();
			
			while (rs.next()) {
				Employee employee = new Employee(rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getDouble(7));
				employee.setId(rs.getInt(1));
				employees.add(employee);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return employees;
	}
		
		
		
		
	
	/*static public Employee save(Employee employee) {
		
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11223305?useSSL=false", "sql11223305", "Tt1GjmaCpL")) {
			
			final String sql = "INSERT INTO EMPLOYEE(id, name, surname, address, phone_number, note, "
					+ "cost_of_operating_hour) VALUES(default, ?, ?, ?, ?, ?, ?);";
			PreparedStatement query = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			query.setString(1, employee.getName());
			query.setString(2, employee.getSurname());
			query.setString(3, employee.getAddress());
			query.setInt(4, employee.getPhoneNumber());
			query.setString(5, employee.getNote());
			query.setDouble(6, employee.getCostOfOperatingHour());
			
			query.executeUpdate();
			
			ResultSet rs = query.getGeneratedKeys();
			if (rs.next()) {
				employee.setId(rs.getInt(1));
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Employee has been saved!");
		return employee;
	}
	
	static public Employee load(int id) {
		
		Employee employee = null;
		
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11223305?useSSL=false", "sql11223305", "Tt1GjmaCpL")) {
			
			PreparedStatement query = conn.prepareStatement("SELECT * FROM EMPLOYEE WHERE id=?");
			query.setInt(1, id);
			ResultSet rs = query.executeQuery();
			
			while (rs.next()) {
				employee = new Employee(rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getDouble(7));
				employee.setId(rs.getInt(1));
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return employee;
	}
	
	
	static public boolean delete(int id) throws Exception {
		
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11223305?useSSL=false", "sql11223305", "Tt1GjmaCpL")) {
			
			PreparedStatement query = conn.prepareStatement("DELETE FROM EMPLOYEE WHERE id=?;");
			query.setInt(1, id);
			
			query.executeUpdate();
			
			System.out.println("Employee has been deleted!");
			return true;
			
		} catch (Exception e) {
			throw new Exception(e.getMessage()); 
		}
	}*/
	
}
