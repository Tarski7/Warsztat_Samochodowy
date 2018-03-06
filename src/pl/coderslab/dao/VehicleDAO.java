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

	static public List<Vehicle> loadAll() {

		List<Vehicle> vehicles = new ArrayList<>();

		try {
			
			Connection conn = DatabaseClient.getConnection();
			
			PreparedStatement query = conn.prepareStatement("SELECT * FROM VEHICLE");
			ResultSet rs = query.executeQuery();

			while (rs.next()) {
				Vehicle vehicle = new Vehicle(rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5),
						rs.getDate(6), rs.getInt(7));
				vehicle.setId(rs.getInt(1));
				vehicles.add(vehicle);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return vehicles;
	}

	static public Vehicle load(int id) {

		Vehicle vehicle = null;

		try {
			
			Connection conn = DatabaseClient.getConnection();

			PreparedStatement query = conn.prepareStatement("SELECT * FROM VEHICLE WHERE id=?");
			query.setInt(1, id);
			ResultSet rs = query.executeQuery();

			while (rs.next()) {
				vehicle = new Vehicle(rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getDate(6),
						rs.getInt(7));
				vehicle.setId(rs.getInt(1));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return vehicle;
	}

	public static void updateVehicle(String query, List<String> params) {

		try {
			
			Connection conn = DatabaseClient.getConnection();

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
			e.printStackTrace();
		}

	}

	static public List<Order> showRepairHistory(int vehicleId) {
		List<Order> repairHistory = new ArrayList<>();
		
		String query = "SELECT id, date_of_start_repair, description_of_the_repair FROM ORDERS WHERE vehicle_id=?;";
		
		try {
			
			Connection conn = DatabaseClient.getConnection();
			
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, vehicleId);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Order order = new Order(rs.getInt(1), rs.getString(2), rs.getString(3), vehicleId);
				repairHistory.add(order);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return repairHistory;
	}
}