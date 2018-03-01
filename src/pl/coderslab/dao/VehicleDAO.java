package pl.coderslab.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pl.coderslab.entity.Vehicle;
import pl.coderslab.service.DatabaseClient;

public class VehicleDAO {

	public static List<String> addVehicle(String model, String brand, String yearOfProduction, String registrationNumber, String dateOfNextTechnicalInspection, String customerId) {
		
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
		
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11223305?useSSL=false", "sql11223305", "Tt1GjmaCpL")) {
			
			PreparedStatement query = conn.prepareStatement("SELECT * FROM VEHICLE");
			ResultSet rs = query.executeQuery();
			
			while (rs.next()) {
				Vehicle vehicle = new Vehicle(rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getDate(6), rs.getInt(7));
				vehicle.setId(rs.getInt(1));
				vehicles.add(vehicle);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return vehicles;
	}


	
	/*static public Vehicle save(Vehicle vehicle) {
		
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11223305?useSSL=false", "sql11223305", "Tt1GjmaCpL")) {
			
			final String sql = "INSERT INTO VEHICLE(id, model, brand, year_of_production, registration_number, "
					+ "date_of_next_technical_inspection, customer_id) VALUES(default, ?, ?, ?, ?, ?, ?);";
			PreparedStatement query = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			query.setString(1, vehicle.getModel());
			query.setString(2, vehicle.getBrand());
			query.setDate(3, new java.sql.Date(vehicle.getYearOfProduction().getTime()));
			query.setString(4, vehicle.getRegistrationNumber());
			query.setDate(5, new java.sql.Date(vehicle.getDateOfNextTechnicalInspection().getTime()));
			query.setInt(6, vehicle.getCustomerId());
			
			query.executeUpdate();
			
			ResultSet rs = query.getGeneratedKeys();
			if (rs.next()) {
				vehicle.setId(rs.getInt(1));
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Vehicle has been saved!");
		return vehicle;
	}*/
	
	/*static public Vehicle load(int id) {
		
		Vehicle vehicle = null;
		
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11223305?useSSL=false", "sql11223305", "Tt1GjmaCpL")) {
			
			PreparedStatement query = conn.prepareStatement("SELECT * FROM VEHICLE WHERE id=?");
			query.setInt(1, id);
			ResultSet rs = query.executeQuery();
			
			while (rs.next()) {
				vehicle = new Vehicle(rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getDate(6), rs.getInt(7));
				vehicle.setId(rs.getInt(1));
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return vehicle;
	}*/
	
	
	/*static public boolean delete(int id) throws Exception {
		
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11223305?useSSL=false", "sql11223305", "Tt1GjmaCpL")) {
			
			PreparedStatement query = conn.prepareStatement("DELETE FROM VEHICLE WHERE id=?");
			query.setInt(1, id);
			
			query.executeUpdate();
			
			System.out.println("Vehicle has been deleted!");
			return true;
			
		} catch (Exception e) {
			throw new Exception(e.getMessage()); 
		}
	}*/
}
