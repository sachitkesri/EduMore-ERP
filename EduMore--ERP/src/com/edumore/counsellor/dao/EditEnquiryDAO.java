package com.edumore.counsellor.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edumore.counsellor.bean.EnquiryBean;
import com.edumore.databseconnection.EdumoreDBConnection;

public class EditEnquiryDAO {
	private Connection con;
	public EnquiryBean editEnquiry(String enquiryId) throws SQLException, ClassNotFoundException {
		con = (Connection) EdumoreDBConnection.getDBConnection();
		String query = "SELECT * FROM enquiry_details where enquiry_number = '"+enquiryId+"'";  
		Statement st = null;
		st = con.createStatement();
		ResultSet rs =  st.executeQuery(query);
		EnquiryBean bean = new EnquiryBean();
		
		while(rs.next()){ 
			bean.setEnquiry_id(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setMiddleName(rs.getString(3)); 
			bean.setLastName(rs.getString(4));
			bean.setResidenceNumber(rs.getString(5));
			bean.setMobileNumber(rs.getString(6));
			bean.setEmailId(rs.getString(7));
			bean.setDateOfBirth(rs.getString(8));
			bean.setGender(rs.getString(9));
			bean.setFatherFirstName(rs.getString(10));
			bean.setFatherMiddleName(rs.getString(11));
			
		}
		return bean;
	}

}
