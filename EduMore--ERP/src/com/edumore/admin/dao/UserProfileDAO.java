package com.edumore.admin.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.edumore.admin.bean.UserBean;
import com.edumore.databseconnection.EdumoreDBConnection;
import com.mysql.jdbc.PreparedStatement;

public class UserProfileDAO {
	
	private Connection conn;

	public boolean addNewUser(UserBean userBean) throws SQLException, ClassNotFoundException {
		conn = EdumoreDBConnection.getDBConnection();
		String sql = "insert into user_details(name,role,email,contactnumber,date_of_joining,address,username,password) values(?,?,?,?,?,?,?,?)";
		PreparedStatement statement = (PreparedStatement) conn.prepareStatement(sql);
		statement.setString(1, userBean.getName());
		statement.setString(2, userBean.getRole());
		statement.setString(3, userBean.getEmail());
		statement.setString(4, userBean.getContactNumber());
		statement.setDate(5, userBean.getDateOfJoining());
		statement.setString(6, userBean.getAddress());
		statement.setString(7, userBean.getUsername());
		statement.setString(8, userBean.getPassword());
		int isAdded = statement.executeUpdate();
		if(isAdded != -1){
			return true;
		}else{
			return false;
		}
		
	}

}
