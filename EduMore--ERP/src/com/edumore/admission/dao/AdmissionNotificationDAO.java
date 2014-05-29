package com.edumore.admission.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.edumore.databseconnection.EdumoreDBConnection;

public class AdmissionNotificationDAO {

	private Connection con;
	public ArrayList<String> fetchRegistrations() throws SQLException, ClassNotFoundException {
		ArrayList<String> enquiryNumbers = new ArrayList<String>();
		String query = "SELECT enquiry_number FROM enquiry_details";
		con = EdumoreDBConnection.getDBConnection();
		Statement st = null;
		st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next()){
			enquiryNumbers.add(rs.getString(1));
		}
		
		return enquiryNumbers;
	}

}
