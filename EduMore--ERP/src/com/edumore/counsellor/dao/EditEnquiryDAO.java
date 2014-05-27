package com.edumore.counsellor.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edumore.counsellor.bean.Address;
import com.edumore.counsellor.bean.EnquiryBean;
import com.edumore.databseconnection.EdumoreDBConnection;

public class EditEnquiryDAO {
	private Connection con;
	public EnquiryBean editEnquiry(String enquiryId) throws SQLException, ClassNotFoundException {
		con = (Connection) EdumoreDBConnection.getDBConnection();
		String query = "SELECT * FROM enquiry_details where enquiry_number = '"+enquiryId+"'";  
		Statement st = null;
		st = con.createStatement();
		Address currentAddress = new EditEnquiryDAO().getAddress(enquiryId, "current");
		Address permanentAddress = new EditEnquiryDAO().getAddress(enquiryId, "permanent");
		ResultSet rs =  st.executeQuery(query);
		EnquiryBean bean = new EnquiryBean();
		bean.setCurrentAddress(currentAddress);
		bean.setPermanentAddress(permanentAddress);
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
	
	private Address getAddress(String enquiryId, String addressType) throws SQLException, ClassNotFoundException {
		con = (Connection) EdumoreDBConnection.getDBConnection();
		String query = "SELECT * FROM address_details where enquiry_number = '"+enquiryId+"' AND address_type='" + addressType + "'" ;  
		Statement st = null;
		st = con.createStatement();
		ResultSet rs =  st.executeQuery(query);
		Address bean = new Address();
		
		while(rs.next()){ 
			bean.setAddressId(rs.getInt(1));
			bean.setHouseNumber(rs.getString(2));
			bean.setBuildingName(rs.getString(3)); 
			bean.setRoadName(rs.getString(4));
			bean.setAreaDetail(rs.getString(5));
			bean.setCity(rs.getString(6));
			bean.setState(rs.getString(7));
			bean.setPincode(rs.getString(9));
			bean.setEnquiryNumber(Long.parseLong(rs.getString(10)));
			bean.setAddressType(rs.getString(10));
			
		}
		return bean;
	}

}
