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
			
//			String query = "INSERT INTO ORDERS VALUES(default, '"+order.getDateOfAcceptanceForRepair()+"', '"
//							+order.getPlannedDateOfStartRepair()+"', '"+order.getDateOfStartRepair()+"', '"
//							+order.getDescriptionOfTheProblem()+"', "+order.getStatus()+", "
//							+order.getCostOfRepair()+", "+order.getCostOfUsedParts()+", "
//							+order.getCostOfOperatingHourOfEmployee()+", "+order.getNumberOfOperatingHours()+", "
//							+order.getEmployeeId()+", "+order.getVehicleId()+");";
			
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
			st.setDouble(9, order.getCostOfOperatingHourOfEmployee());
			st.setDouble(10, order.getNumberOfOperatingHours());
			st.setDouble(11, order.getEmployeeId());
			st.setInt(12, order.getVehicleId());
		
			st.executeUpdate();
			
			ResultSet rs = st.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
