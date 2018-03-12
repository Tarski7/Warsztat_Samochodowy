package pl.coderslab.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class DatabaseClient {

	static public Connection getConnection() throws Exception {

		final String URL = "jdbc:mysql://sql11.freemysqlhosting.net/sql11225568?useSSL=false";
		final String USERNAME = "sql11225568";
		final String PASSWORD = "suVzFmxuFn";

		try {

			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			return conn;

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	static public int add(String query, List<String> params) throws Exception {

		Connection conn = null;

		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			for (int i = 1; i <= params.size(); i++) {
				stmt.setString(i, params.get(i - 1));
			}

			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();

			return rs.getInt(1);

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					throw new Exception(e.getMessage());
				}
			}
		}
	}

	static public boolean delete(String query, int id) throws Exception {

		Connection conn = null;

		try {

			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, id);

			stmt.executeUpdate();

			return true;

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

	static public double countSum(String dateFrom, String dateTo) throws Exception {

		double sum = 0;

		try {

			Connection conn = getConnection();

			String query = "SELECT SUM(cost_of_repair) FROM ORDERS WHERE date_of_start_repair BETWEEN '" + dateFrom
					+ "' AND '" + dateTo + "';";

			PreparedStatement stmt = conn.prepareStatement(query);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				sum = rs.getDouble(1);
			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

		return sum;
	}

}

// TODO :: Update
// TODO :: Select
