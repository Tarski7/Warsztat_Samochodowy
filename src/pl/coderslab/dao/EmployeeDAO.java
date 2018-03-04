package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pl.coderslab.entity.Employee;
import pl.coderslab.entity.Order;

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
	
	public static void updateEmployee(String query, List<String> params) {

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11223305?useSSL=false", "sql11223305", "Tt1GjmaCpL")) {

			String name = params.get(0);
			String surname = params.get(1);
			String address = params.get(2);
			String phoneNumber = params.get(3);
			String note = params.get(4);
			String costOfOperatingHour = params.get(5);

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, surname);
			ps.setString(3, address);
			ps.setString(4, phoneNumber);
			ps.setString(5, note);
			ps.setString(6, costOfOperatingHour);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	static public List<Order> showEmployeeRepairs(int id) throws Exception {

		List<Order> employeeRepairs = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11223305?useSSL=false", "sql11223305", "Tt1GjmaCpL")) {

			String query = "SELECT ORDERS.id, ORDERS.date_of_acceptance_for_repair, "
					+ "ORDERS.planned_date_of_start_repair, ORDERS.date_of_start_repair, "
					+ "ORDERS.description_of_the_problem, ORDERS.description_of_the_repair, "
					+ "ORDERS.status, ORDERS.cost_of_repair, ORDERS.cost_of_used_parts, "
					+ "ORDERS.cost_of_operating_hour_of_employee, ORDERS.number_of_operating_hours, "
					+ "ORDERS.vehicle_id FROM EMPLOYEE JOIN ORDERS ON EMPLOYEE.id = ORDERS.employee_id "
					+ "WHERE EMPLOYEE.id=? AND status='in repair';";
			
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, id);
			
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Order order = new Order(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDouble(8), rs.getDouble(9), rs.getDouble(10), rs.getInt(11), rs.getInt(12));
				employeeRepairs.add(order);
			}

			return employeeRepairs;
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
}
