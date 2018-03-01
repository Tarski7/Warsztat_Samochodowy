package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pl.coderslab.entity.Customer;

public class CustomerDAO {

	static private final String URL = "jdbc:mysql://sql11.freemysqlhosting.net/sql11223305?useSSL=false";
	static private final String USERNAME = "sql11223305";
	static private final String PASSWORD = "Tt1GjmaCpL";

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

	public static List<Customer> loadAll() {

		List<Customer> customers = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

			PreparedStatement query = conn.prepareStatement("SELECT * FROM CUSTOMER");
			ResultSet rs = query.executeQuery();

			while (rs.next()) {
				Customer customer = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				customers.add(customer);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return customers;
	}

	public static boolean updateCustomer(Customer customer) {

		List<String> updateQueries = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

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

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
}
