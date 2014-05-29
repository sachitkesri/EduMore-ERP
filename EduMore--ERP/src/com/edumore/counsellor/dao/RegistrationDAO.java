package com.edumore.counsellor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.edumore.counsellor.bean.RegistrationBean;
import com.edumore.databseconnection.EdumoreDBConnection;

public class RegistrationDAO {

	private Connection con;
	public boolean registerEnquiry(RegistrationBean registrationBean,
			String type) throws SQLException {
		boolean isRegistered = false;
		try{
			con = (Connection) EdumoreDBConnection.getDBConnection();
			con.setAutoCommit(false);
			String sql = "insert into payment_details(date,amount,type,enquiry_number) values(?,?,?,?)";
			PreparedStatement statement = (PreparedStatement) con
					.prepareStatement(sql);
			statement.setDate(1, registrationBean.getRegistrationDate());
			statement.setFloat(2, registrationBean.getRegistrationFee());
			statement.setString(3, type);
			statement.setString(4, registrationBean.getEnquiryNumber());
			int updated = statement.executeUpdate();
			System.out.println("up" + updated);
			isRegistered = updateEnquiryStatus(registrationBean.getEnquiryNumber());
			
			con.commit();
			return isRegistered;
		}catch (Exception e) {
			e.printStackTrace();
			con.rollback();
			return false;
		}
	}
	private boolean updateEnquiryStatus(String enquiryNumber) throws SQLException, ClassNotFoundException {
		System.out.println(enquiryNumber);
		String sql = "UPDATE enquiry_details SET enquiry_status=?, admission_status=? WHERE enquiry_number='" + enquiryNumber +"'";
		PreparedStatement statement = (PreparedStatement) con.prepareStatement(sql);
		statement.setString(1, "close");
		statement.setString(2, "registered");
		int updated = statement.executeUpdate();
		System.out.println(updated);
		//if(updated != -1){
			return true;
		//}else return false;
		
	}

}
