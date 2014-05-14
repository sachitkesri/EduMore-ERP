package com.edumore.admin.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.edumore.admin.bean.AdminLoginBean;
import com.edumore.databseconnection.EdumoreDBConnection;

public class AdminLoginDAO {
	private static Connection con;
	public AdminLoginBean selectAdminLoginCrendetials(AdminLoginBean loginBean) throws SQLException, ClassNotFoundException {
		con = (Connection) EdumoreDBConnection.getDBConnection();
		AdminLoginBean adminLoginBean = new AdminLoginBean();
		Statement statement=  (Statement) con.createStatement();
		ResultSet rs = (ResultSet) statement.executeQuery("Select * from admin_login_details where admin_username = \"" + loginBean.getUsername() +"\" AND admin_password= \"" + loginBean.getPassword() + "\"");
		while(rs.next()){
	         //Retrieve by column name
			adminLoginBean.setAdminLoginId(rs.getInt("admin_id"));
	        adminLoginBean.setUsername( rs.getString("admin_username"));
	        adminLoginBean.setPassword( rs.getString("admin_password"));
	      }
	      rs.close();
		return adminLoginBean;
	}

}
