package com.edumore.home.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.edumore.admin.bean.UserBean;
import com.edumore.databseconnection.EdumoreDBConnection;

public class LoginDAO {
	
	private static Connection con;

	public static UserBean verifyLogin(String username, String password) throws SQLException, ClassNotFoundException {
		con = (Connection) EdumoreDBConnection.getDBConnection();
		UserBean profile = new UserBean();
		String query = "SELECT user_id, role FROM user_details where username='"+username+"' AND password='"+password+"'";  
		Statement st = null;
		st = con.createStatement();
		ResultSet rs =  st.executeQuery(query);
		while(rs.next()){
			profile.setUserId(rs.getInt(1));
			profile.setRole(rs.getString(2));
		}
		return profile;
	}

}
