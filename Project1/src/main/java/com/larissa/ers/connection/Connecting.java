package com.larissa.ers.connection;

import java.sql.*;
import org.postgresql.Driver;

public class Connecting {

	public static Connection getConnection() throws SQLException {
		Driver PostgresDriver = new Driver();
		DriverManager.registerDriver(PostgresDriver);
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String user = "postgres";
		String pass = "81089958";
		return DriverManager.getConnection(url, user, pass);
	}
	
	// This main method is used to test our connection!
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String user = "postgres";
		String pass = "81089958";
		// try with resources allows you to pass a resource argument to a try statement
		// in this case the
		try (Connection con = Connecting.getConnection()) {
			System.out.println("The Connection was successful!"); // if this works, our connection was established
		} catch(SQLException e) {
			System.out.println("An Error Occured");
			e.printStackTrace();
		}
		
		
	}
	

}

