package com.edumore.counsellor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.edumore.counsellor.bean.Address;
import com.edumore.counsellor.bean.EnquiryBean;
import com.edumore.databseconnection.EdumoreDBConnection;

public class NewEnquiryDAO {
	private static Connection con;
	public boolean addNewEnquiry(EnquiryBean enquiryBean) throws SQLException, ClassNotFoundException {
		con = (Connection) EdumoreDBConnection.getDBConnection();
		con.setAutoCommit(false);
		addEducationQualification(enquiryBean);
		addNewAddress(enquiryBean, enquiryBean.getCurrentAddress(), "current");
		addNewAddress(enquiryBean, enquiryBean.getPermanentAddress(), "permanent");
		int currentAddressId = fetchAddress(enquiryBean.getEnquiryNumber(), "current");
		int permanentAddressId = fetchAddress(enquiryBean.getEnquiryNumber(), "permanent");
		//'"+enquiryBean.getCurrentAddress().getHouseNumber()+"','"+enquiryBean.getCurrentAddress().getBuildingName()+"','"+enquiryBean.getCurrentAddress().getRoadName()+"','"+enquiryBean.getCurrentAddress().getAreaDetail()+"','"+enquiryBean.getCurrentAddress().getCity()+"','"+enquiryBean.getCurrentAddress().getState()+"','"+enquiryBean.getCurrentAddress().getPincode()+"'
		String sql = "insert into enquiry_details(first_name,middle_name,last_name,residence_number,mobile_number,email_id,date_of_birth,gender,father_first_name,father_middle_name,father_last_name,father_mobile_number,father_residence_number,current_address,permanent_address,counsellor_id,enquiry_number) values(?,?,?,?,?,?,?,?,?,?,?,?,?,"+currentAddressId+","+permanentAddressId+",(SELECT counsellor_id FROM counsellor_login_details WHERE counsellor_id="
				+ 1 + "),?)";
		PreparedStatement statement = (PreparedStatement) con
				.prepareStatement(sql);
		statement.setString(1, enquiryBean.getFirstName());
		statement.setString(2, enquiryBean.getMiddleName());
		statement.setString(3, enquiryBean.getLastName());
		statement.setString(4, enquiryBean.getResidenceNumber());
		statement.setString(5, enquiryBean.getMobileNumber());
		statement.setString(6, enquiryBean.getEmailId());
		statement.setString(7, enquiryBean.getDateOfBirth());
		statement.setString(8, enquiryBean.getGender());
		statement.setString(9, enquiryBean.getFatherFirstName());
		statement.setString(10, enquiryBean.getFatherMiddleName());
		statement.setString(11, enquiryBean.getFatherLastName());
		statement.setString(12, enquiryBean.getFatherMobileNumber());
		statement.setString(13, enquiryBean.getFatherResidenceNumber());
		statement.setLong(14, enquiryBean.getEnquiryNumber());
		
		// statement.setInt(2, courseBean.getAdminId());
		int updated = statement.executeUpdate();
		con.commit();
		if (updated == 1) {
			return true;
		} else
			return false;
	}
	
	private void addEducationQualification(EnquiryBean enquiryBean) {
		// TODO Auto-generated method stub
		
	}

	public boolean updateEnquiry(EnquiryBean enquiryBean) throws SQLException, ClassNotFoundException {
		con = (Connection) EdumoreDBConnection.getDBConnection();
		con.setAutoCommit(false);
		updateAddress(enquiryBean, enquiryBean.getCurrentAddress(), "current");
		updateAddress(enquiryBean, enquiryBean.getPermanentAddress(), "permanent");
		String sql = "update enquiry_details SET first_name = ?,middle_name = ?,last_name = ?,residence_number = ?,mobile_number = ?,email_id = ?,date_of_birth = ?,gender = ?,father_first_name =  ?,father_middle_name = ?,father_last_name = ?,father_mobile_number = ?,father_residence_number = ? where enquiry_id = " + enquiryBean.getEnquiry_id();
		PreparedStatement statement = (PreparedStatement) con.prepareStatement(sql);
		statement.setString(1, enquiryBean.getFirstName());
		statement.setString(2, enquiryBean.getMiddleName());
		statement.setString(3, enquiryBean.getLastName());
		statement.setString(4, enquiryBean.getResidenceNumber());
		statement.setString(5, enquiryBean.getMobileNumber());
		statement.setString(6, enquiryBean.getEmailId());
		statement.setString(7, enquiryBean.getDateOfBirth());
		statement.setString(8, enquiryBean.getGender());
		statement.setString(9, enquiryBean.getFatherFirstName());
		statement.setString(10, enquiryBean.getFatherMiddleName());
		statement.setString(11, enquiryBean.getFatherLastName());
		statement.setString(12, enquiryBean.getFatherMobileNumber());
		statement.setString(13, enquiryBean.getFatherResidenceNumber());
		int updated = statement.executeUpdate();
		con.commit();
		if (updated == 1) {
			return true;
		} else
			return false;
	}
	
	
	private void updateAddress(EnquiryBean enquiryBean, Address address, String addressType) throws SQLException {
		System.out.println("-----");
		System.out.println(enquiryBean.getEnquiryNumber());
		String sql = "UPDATE address_details SET house_number = ?,building_name = ?,street = ?,area = ?,city = ?,state = ?,pincode = ? WHERE enquiry_number='" + enquiryBean.getEnquiryNumber() + "' AND address_type='" +addressType +"'" ;
		PreparedStatement statement = (PreparedStatement) con.prepareStatement(sql);
		statement.setString(1, address.getHouseNumber());
		statement.setString(2, address.getBuildingName());
		statement.setString(3, address.getRoadName());
		statement.setString(4, address.getAreaDetail());
		statement.setString(5, address.getCity());
		statement.setString(6, address.getState());
		statement.setString(7, address.getPincode());
		statement.executeUpdate();
		
		
	}

	public boolean addNewAddress(EnquiryBean enquiryBean, Address address, String addressType) throws SQLException, ClassNotFoundException {

		//con = (Connection) EdumoreDBConnection.getDBConnection();
		//'"+enquiryBean.getCurrentAddress().getHouseNumber()+"','"+enquiryBean.getCurrentAddress().getBuildingName()+"','"+enquiryBean.getCurrentAddress().getRoadName()+"','"+enquiryBean.getCurrentAddress().getAreaDetail()+"','"+enquiryBean.getCurrentAddress().getCity()+"','"+enquiryBean.getCurrentAddress().getState()+"','"+enquiryBean.getCurrentAddress().getPincode()+"'
		String sql = "insert into address_details(house_number,building_name,street,area,city,state,country,pincode,enquiry_number,address_type) values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement statement = (PreparedStatement) con
				.prepareStatement(sql);
		statement.setString(1, address.getHouseNumber());
		statement.setString(2, address.getBuildingName());
		statement.setString(3, address.getRoadName());
		statement.setString(4, address.getAreaDetail());
		statement.setString(5, address.getCity());
		statement.setString(6, address.getState());
		statement.setString(7, "India");
		statement.setString(8, address.getPincode());
		statement.setLong(9, enquiryBean.getEnquiryNumber());
		statement.setString(10, addressType);
		int updated = statement.executeUpdate();
		if (updated == 1) {
			return true;
		} else
			return false;
	
	}
	
	public int fetchAddress(long enquiryNumber, String addressType) throws SQLException, ClassNotFoundException{ 
		String query = "SELECT * FROM address_details where enquiry_number = " + enquiryNumber + " AND address_type ='" + addressType +"'";  
		Statement st = null;
		int id = 0;
		st = con.createStatement();
		ResultSet rs =  st.executeQuery(query);
		while(rs.next())
			id = rs.getInt(1);
		return id;
		
	}

}
