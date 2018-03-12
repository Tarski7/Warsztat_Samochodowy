package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pl.coderslab.entity.Order;
import pl.coderslab.entity.Vehicle;
import pl.coderslab.service.DatabaseClient;

public class VehicleDAO {
	
	public static List<String> addVehicle(String model, String brand, String yearOfProduction,
			String registrationNumber, String dateOfNextTechnicalInspection, String customerId) {

		List<String> vehicles = new ArrayList<>();

		vehicles.add(model);
		vehicles.add(brand);
		vehicles.add(yearOfProduction);
		vehicles.add(registrationNumber);
		vehicles.add(dateOfNextTechnicalInspection);
		vehicles.add(customerId);

		return vehicles;
	}

	static public List<Vehicle> loadAll() throws Exception {

		List<Vehicle> vehicles = new ArrayList<>();
		Connection conn = null;

		try {
			
			conn = DatabaseClient.getConnection();
			
			PreparedStatement query = conn.prepareStatement("SELECT * FROM VEHICLE");
			ResultSet rs = query.executeQuery();

			while (rs.next()) {
				Vehicle vehicle = new Vehicle(rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5),
						rs.getDate(6), rs.getInt(7));
				vehicle.setId(rs.getInt(1));
				vehicles.add(vehicle);
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

		return vehicles;
	}

	static public Vehicle load(int id) throws Exception {

		Vehicle vehicle = null;
		Connection conn = null;

		try {
			
			conn = DatabaseClient.getConnection();

			PreparedStatement query = conn.prepareStatement("SELECT * FROM VEHICLE WHERE id=?");
			query.setInt(1, id);
			ResultSet rs = query.executeQuery();

			while (rs.next()) {
				vehicle = new Vehicle(rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getDate(6),
						rs.getInt(7));
				vehicle.setId(rs.getInt(1));
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

		return vehicle;
	}

	public static void updateVehicle(String query, List<String> params) throws Exception {

		Connection conn = null;
		
		try {
			
			conn = DatabaseClient.getConnection();

			String model = params.get(0);
			String brand = params.get(1);
			String yearOfProduction = params.get(2);
			String registrationNumber = params.get(3);
			String dateOfNextTechnicalInspection = params.get(4);
			String customerId = params.get(5);

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, model);
			ps.setString(2, brand);
			ps.setString(3, yearOfProduction);
			ps.setString(4, registrationNumber);
			ps.setString(5, dateOfNextTechnicalInspection);
			ps.setString(6, customerId);
			ps.executeUpdate();

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

	static public List<Order> showRepairHistory(int vehicleId) throws Exception {
		List<Order> repairHistory = new ArrayList<>();
		Connection conn = null;
		
		
		String query = "SELECT id, date_of_start_repair, description_of_the_repair FROM ORDERS WHERE vehicle_id=?;";
		
		try {
			
			conn = DatabaseClient.getConnection();
			
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, vehicleId);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Order order = new Order(rs.getInt(1), rs.getString(2), rs.getString(3), vehicleId);
				repairHistory.add(order);
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
		
		return repairHistory;
	}
}