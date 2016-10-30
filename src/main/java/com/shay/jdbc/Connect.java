package com.shay.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	
	protected static Connection getConnection(String nomeBanco, String usuario,
			String senha) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			return DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/"+nomeBanco,usuario,senha);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
