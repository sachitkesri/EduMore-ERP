package com.edumore.counsellor.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.edumore.counsellor.bean.Address;
import com.edumore.counsellor.bean.EducationalQualification;
import com.edumore.counsellor.bean.EnquiryBean;
import com.edumore.databseconnection.EdumoreDBConnection;

public class EditEnquiryDAO {
	private Connection con;
	public EnquiryBean editEnquiry(String enquiryId) throws SQLException, ClassNotFoundException {
		con = (Connection) EdumoreDBConnection.getDBConnection();
		String query = "SELECT * FROM enquiry_details where enquiry_number = '"+enquiryId+"'";  
		Statement st = null;
		st = con.createStatement();
		Address currentAddress = getAddress(enquiryId, "current");
		Address permanentAddress = getAddress(enquiryId, "permanent");
		ArrayList<EducationalQualification> educationalQualifications = getEducationalQualification(enquiryId);
		ResultSet rs =  st.executeQuery(query);
		EnquiryBean bean = new EnquiryBean();
		bean.setCurrentAddress(currentAddress);
		bean.setPermanentAddress(permanentAddress);
		bean.setEducationalQualifications(educationalQualifications);
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
			bean.setEnquiryNumber(rs.getLong(18));
			
		}
		return bean;
	}
	
	private ArrayList<EducationalQualification> getEducationalQualification(
			String enquiryId) throws SQLException, ClassNotFoundException {
		con = (Connection) EdumoreDBConnection.getDBConnection();
		String query = "SELECT * FROM education_details where enquiry_number='"+enquiryId+"'" ;  
		Statement st = null;
		st = con.createStatement();
		ArrayList<EducationalQualification> educationalQualifications = new ArrayList<EducationalQualification>();
		
		ResultSet rs =  st.executeQuery(query);
		
		while(rs.next()){ 
			EducationalQualification bean = new EducationalQualification();
			bean.setEducationId(rs.getInt(1));
			bean.setQualification(rs.getString(2));
			bean.setCollege(rs.getString(3)); 
			bean.setStatus(rs.getString(4));
			bean.setUnversity(rs.getString(5));
			bean.setCompletedYear(rs.getString(6));
			bean.setGrade(rs.getString(7));
			bean.setEnquiryNumber(Long.parseLong(rs.getString(8)));
			educationalQualifications.add(bean);
		}
		return educationalQualifications;
	
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
