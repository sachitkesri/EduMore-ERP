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

public class EnquiryListDAO {
	private Connection con;

	public List<EnquiryBean> listEnquiries() throws SQLException,
			ClassNotFoundException {
		String query = "SELECT * FROM enquiry_details";
		con = EdumoreDBConnection.getDBConnection();
		Statement st = null;
		st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		// EnquiryBean bean = new EnquiryBean();
		List<EnquiryBean> enquiryBeans = new ArrayList<EnquiryBean>();
		while (rs.next()) {
			EnquiryBean bean = new EnquiryBean();
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
			bean.setFatherLastName(rs.getString(12));
			bean.setFatherResidenceNumber(rs.getString(13));
			bean.setFatherMobileNumber(rs.getString(15));
			bean.setCurrentAddress(fetchAddress(bean.getEnquiry_id(), "current"));
			bean.setPermanentAddress(fetchAddress(bean.getEnquiry_id(), "current"));
			bean.setEnquiryNumber(Long.parseLong(rs.getString(18)));
			
			enquiryBeans.add(bean);
		}
		
		return enquiryBeans;
	}
	
	public Address fetchAddress(long enquiryNumber, String addressType) throws SQLException, ClassNotFoundException{ 
		String query = "SELECT * FROM address_details where enquiry_number = " + enquiryNumber + " AND address_type ='" + addressType +"'";  
		Statement st = null;
		Address address = new Address();
		st = con.createStatement();
		ResultSet rs =  st.executeQuery(query);
		while(rs.next()){
			address.setAddressId(rs.getInt(1));
			address.setHouseNumber(rs.getString(2));
			address.setBuildingName(rs.getString(3));
			address.setRoadName(rs.getString(4));
			address.setAreaDetail(rs.getString(5));
			address.setCity(rs.getString(6));
			address.setState(rs.getString(7));
			address.setPincode(rs.getString(9));
			address.setEnquiryNumber(rs.getLong(10));
			address.setAddressType(rs.getString(11));
		}
		return address;
		
	}

}
