package edu.eoi.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataUtilities {

	public static Connection openConnection(){
		
		String url = "jdbc:mysql://localhost:3306/happypeoit?serverTimezone=UTC&useSSL=false";
		String user = "root";
		String pass = "1234";
		
		Connection conexion = null;
		try {
			//Establecer conexion
			conexion = DriverManager.getConnection(url, user, pass);
			conexion.setAutoCommit(true);
		} catch (SQLException e) {
			System.out.println("No se ha podido conectar a ".concat(url));
			e.printStackTrace();
		}
		
		return conexion;
	}

	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
}
