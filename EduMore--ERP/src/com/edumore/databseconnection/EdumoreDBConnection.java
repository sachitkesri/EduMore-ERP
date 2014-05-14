/**
 * 
 */
package com.edumore.databseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Sachit Kesri
 * 
 */
public class EdumoreDBConnection {

	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/edumore";
	private static final String USERNAME = "root";

	private static final String PASSWORD = "root";

	public static Connection getDBConnection() throws SQLException,
			ClassNotFoundException {
		Connection con = null;
		Class.forName(DRIVER_NAME);
		con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		return con;
	}

}
