package pl.coderslab.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DbEmployee {

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
	
	public static List< HashMap<String, String> > selectQuery(String query, String[] params) throws Exception {
		
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD)){
			
			PreparedStatement st = con.prepareStatement(query);
			for (int i = 0; i < params.length; i++) {
				st.setString(i+1, params[i]);	
			}
			
			st.execute();
			ResultSet rs = st.getResultSet();
			
			//get metadata to get columns Count
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			
			//list of hashmaps - each element in list is row from database, with hashMap, we can
			//get easily kolumn from row by name
			List< HashMap<String, String> > result = new ArrayList<>();
			while (rs.next()) {
				//prepare HashMap for row
				HashMap<String, String> row = new HashMap<>();
				
				//columns in Result set are counted from 1 not from 0
				for(int i=1; i<=columnsNumber; i++) {
					row.put( rsmd.getColumnName(i) , rs.getString(i));
				}
				
				//Add row to List
				result.add(row);
				
			}
			
			return result;
		}catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	//TODO :: Update
	//TODO :: Delete
	//TODO :: Select
}
