package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pl.coderslab.entity.Order;

public class OrderDAO {

	static private final String URL = "jdbc:mysql://sql11.freemysqlhosting.net/sql11223305?useSSL=false";
	static private final String USERNAME = "sql11223305";
	static private final String PASSWORD = "Tt1GjmaCpL";

	public static int addOrder(Order order) throws Exception {
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

			String query = "INSERT INTO ORDERS VALUES(default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

			PreparedStatement st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			st.setString(1, order.getDateOfAcceptanceForRepair());
			st.setString(2, order.getPlannedDateOfStartRepair());
			st.setString(3, order.getDateOfStartRepair());
			st.setString(4, order.getDescriptionOfTheProblem());
			st.setString(5, order.getDescriptionOfTheRepair());
			st.setString(6, order.getStatus());
			st.setDouble(7, order.getCostOfRepair());
			st.setDouble(8, order.getCostOfUsedParts());

			
			//Get cost of operating hour of an employee for another table
			String query2 = "SELECT cost_of_operating_hour FROM EMPLOYEE WHERE id=?;";
			PreparedStatement st2 = conn.prepareStatement(query2);
			st2.setInt(1, order.getEmployeeId());
			ResultSet rs2 = st2.executeQuery();
			double costOfOperatingHourOfEmployee = 0.0;
			
			while(rs2.next()) {
				costOfOperatingHourOfEmployee = rs2.getDouble(1);
			}
			
			st.setDouble(9, costOfOperatingHourOfEmployee);
			st.setInt(10, order.getNumberOfOperatingHours());
			st.setInt(11, order.getEmployeeId());
			st.setInt(12, order.getVehicleId());

			System.out.println(st.toString());

			st.executeUpdate();

			ResultSet rs = st.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public static boolean deleteOrder(int id) throws Exception {

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

			String query = "DELETE FROM ORDERS WHERE id=?";

			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, id);
			st.executeUpdate();

			return true;

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public static List<Order> loadAll() {

		List<Order> orders = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

			PreparedStatement query = conn.prepareStatement("SELECT * FROM ORDERS;");
			ResultSet rs = query.executeQuery();

			while (rs.next()) {
				Order order = new Order(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getDouble(8), rs.getDouble(9),
						rs.getDouble(10), rs.getInt(11), rs.getInt(12), rs.getInt(13));
				orders.add(order);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return orders;
	}

	static public Order loadChosenOrder(int id) {

		Order order = null;

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

			PreparedStatement query = conn.prepareStatement("SELECT * FROM ORDERS WHERE id=?;");
			query.setInt(1, id);
			ResultSet rs = query.executeQuery();

			while (rs.next()) {
				order = new Order(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getDouble(8), rs.getDouble(9), rs.getDouble(10),
						rs.getInt(11), rs.getInt(12), rs.getInt(13));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return order;
	}

	static public boolean updateOrder(Order order) throws Exception {

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

			String query = "UPDATE ORDERS SET " + "date_of_acceptance_for_repair=?, "
					+ "planned_date_of_start_repair=?, " + "date_of_start_repair=?, " + "description_of_the_problem=?, "
					+ "description_of_the_repair=?, " + "status=?, " + "cost_of_repair=?, " + "cost_of_used_parts=?, "
					+ "cost_of_operating_hour_of_employee=?, " + "number_of_operating_hours=?, " + "employee_id=?, "
					+ "vehicle_id=? WHERE id=?;";

			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, order.getDateOfAcceptanceForRepair());
			st.setString(2, order.getPlannedDateOfStartRepair());
			st.setString(3, order.getDateOfStartRepair());
			st.setString(4, order.getDescriptionOfTheProblem());
			st.setString(5, order.getDescriptionOfTheRepair());
			st.setString(6, order.getStatus());
			st.setDouble(7, order.getCostOfRepair());
			st.setDouble(8, order.getCostOfUsedParts());
			
			String query2 = "SELECT cost_of_operating_hour FROM EMPLOYEE WHERE id=?;";
			PreparedStatement st2 = conn.prepareStatement(query2);
			st2.setInt(1, order.getEmployeeId());
			ResultSet rs2 = st2.executeQuery();
			
			System.out.println(st2.toString());
			
			double costOfOperatingHourOfEmployee = 0.0;
			
			while(rs2.next()) {
				costOfOperatingHourOfEmployee = rs2.getDouble(1);
			}
			
			st.setDouble(9, costOfOperatingHourOfEmployee);
			st.setInt(10, order.getNumberOfOperatingHours());
			st.setInt(11, order.getEmployeeId());
			st.setInt(12, order.getVehicleId());

			st.setInt(13, order.getId());

			System.out.println(st.toString());
			st.executeUpdate();

			return true;

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	static public boolean updateOrderStatus(int id, String status) throws Exception {

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

			String query = "UPDATE ORDERS SET status=? WHERE id=?";

			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, status);
			st.setInt(2, id);

			st.executeUpdate();

			return true;

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public static List<Order> loadCurrentOrders() {

		List<Order> orders = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

			PreparedStatement query = conn.prepareStatement("SELECT * FROM ORDERS WHERE status='in repair';");
			ResultSet rs = query.executeQuery();

			while (rs.next()) {
				Order order = new Order(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getDouble(8), rs.getDouble(9),
						rs.getDouble(10), rs.getInt(11), rs.getInt(12), rs.getInt(13));
				orders.add(order);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return orders;
	}
}
