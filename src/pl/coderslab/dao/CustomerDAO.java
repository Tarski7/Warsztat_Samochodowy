package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pl.coderslab.entity.Customer;
import pl.coderslab.entity.Vehicle;
import pl.coderslab.service.DatabaseClient;

public class CustomerDAO {

	public static List<String> clientAttributesList(String name, String lastName, String dateofBirth) {

		List<String> attributes = new ArrayList<>();

		attributes.add(name);
		attributes.add(lastName);
		attributes.add(dateofBirth);

		return attributes;
	}

	public static String deleteCustomerQuery() {

		String query = "DELETE FROM CUSTOMER WHERE id=?";

		return query;
	}

	public static List<Customer> loadAll() throws Exception {

		List<Customer> customers = new ArrayList<>();

		Connection conn = null;

		try {

			conn = DatabaseClient.getConnection();

			PreparedStatement query = conn.prepareStatement("SELECT * FROM CUSTOMER");
			ResultSet rs = query.executeQuery();

			while (rs.next()) {
				Customer customer = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				customers.add(customer);
			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}

		return customers;
	}

	public static boolean updateCustomer(Customer customer) throws Exception {

		List<String> updateQueries = new ArrayList<>();

		Connection conn = null;

		try {

			conn = DatabaseClient.getConnection();

			customer.toString();

			int id = customer.getId();
			String name = customer.getName();
			String lastName = customer.getLastName();
			String dateOfBirth = customer.getDateOfBirth();

			if (!name.isEmpty()) {
				String query1 = "UPDATE CUSTOMER SET name='" + name + "' WHERE id=" + id + ";";
				System.out.println(query1);
				updateQueries.add(query1);
			}
			if (!lastName.isEmpty()) {
				String query2 = "UPDATE CUSTOMER SET surname='" + lastName + "' WHERE id=" + id + ";";
				updateQueries.add(query2);
				System.out.println(query2);
			}
			if (dateOfBirth != null) {
				String query3 = "UPDATE CUSTOMER SET date_of_birth='" + dateOfBirth + "' WHERE id=" + id + ";";
				System.out.println(query3);
				updateQueries.add(query3);
			}

			for (int i = 0; i < updateQueries.size(); i++) {
				System.out.println(updateQueries.get(i));
				PreparedStatement st = conn.prepareStatement(updateQueries.get(i));
				st.executeUpdate();
			}

			// TODO: fix customer update - make it only one query.

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}

	}

	static public List<Customer> searchCustomerByLastName(String lastName) throws Exception {

		List<Customer> customers = new ArrayList<>();

		Connection conn = null;
		
		try {

			conn = DatabaseClient.getConnection();

			String query = "SELECT * FROM CUSTOMER WHERE surname LIKE '%" + lastName + "%';";
			PreparedStatement st = conn.prepareStatement(query);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Customer customer = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				customers.add(customer);
			}

			return customers;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}
	}

	static public List<Vehicle> showCustomerCars(int id) throws Exception {

		List<Vehicle> customerCars = new ArrayList<>();

		Connection conn = null;
		
		try {

			conn = DatabaseClient.getConnection();

			String query = "SELECT VEHICLE.id, VEHICLE.model, VEHICLE.brand, VEHICLE.year_of_production, "
					+ "VEHICLE.registration_number, VEHICLE.date_of_next_technical_inspection "
					+ "FROM CUSTOMER JOIN VEHICLE ON CUSTOMER.id = VEHICLE.customer_id WHERE CUSTOMER.id=?;";

			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, id);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Vehicle vehicle = new Vehicle(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4),
						rs.getString(5), rs.getDate(6));
				customerCars.add(vehicle);
			}

			return customerCars;

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}
	}
}
