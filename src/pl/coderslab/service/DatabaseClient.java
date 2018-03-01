package pl.coderslab.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class DatabaseClient {

	static private final String URL = "jdbc:mysql://sql11.freemysqlhosting.net/sql11223305?useSSL=false";
	static private final String USERNAME = "sql11223305";
	static private final String PASSWORD = "Tt1GjmaCpL";
	
	
	static public int add(String query, List<String> params) throws Exception {
		
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)){
		
			PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			for (int i=1; i<=params.size(); i++) {
				stmt.setString(i, params.get(i-1));
			}
			
			stmt.executeUpdate();
			
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);
			
			 
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
	
	static public boolean delete(String query, int id) throws Exception {
		
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, id);
			
			stmt.executeUpdate();

			return true;
			
		} catch (Exception e) {
			throw new Exception(e.getMessage()); 
		}
	}
	
	//TODO :: Update
	//TODO :: Select
}
