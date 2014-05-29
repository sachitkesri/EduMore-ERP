package com.edumore.home.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.edumore.databseconnection.EdumoreDBConnection;

public class LoginDAO {
	
	private static Connection con;

	public static int verifyLogin(String username, String password, String loginType) throws SQLException, ClassNotFoundException {
		con = (Connection) EdumoreDBConnection.getDBConnection();
		String query = "SELECT * FROM user_details where username='"+username+"' AND password='"+password+"' AND role='"+ loginType +"'";  
		Statement st = null;
		int userLoginId = -1; 
		st = con.createStatement();
		ResultSet rs =  st.executeQuery(query);
		while(rs.next()){
			userLoginId = rs.getInt(1);
		}
		return userLoginId;
	}

}
