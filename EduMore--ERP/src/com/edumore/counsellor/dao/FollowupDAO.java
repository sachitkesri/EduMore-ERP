package com.edumore.counsellor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edumore.counsellor.bean.EnquiryBean;
import com.edumore.counsellor.bean.FollowupBean;
import com.edumore.databseconnection.EdumoreDBConnection;

public class FollowupDAO {

	private static Connection con;
	
	public static boolean addFollowup(FollowupBean followupBean) throws SQLException, ClassNotFoundException {
		con = (Connection) EdumoreDBConnection.getDBConnection();
		String sql = "insert into followup(date,remarks,enquiry_id) values(?,?,(SELECT enquiry_id FROM enquiry_details WHERE enquiry_id="
				+ followupBean.getEnquiryId() + "))";
		PreparedStatement statement = (PreparedStatement) con
				.prepareStatement(sql);
		statement.setDate(1, followupBean.getDate());
		statement.setString(2, followupBean.getRemarks());
		
		// statement.setInt(2, courseBean.getAdminId());
		int updated = statement.executeUpdate();
		if (updated == 1) {
			return true;
		} else
			return false;
		
	}

	public static List<FollowupBean> listFollowup(String enquiryId) throws SQLException, ClassNotFoundException {
		String query = "SELECT * FROM followup_details where enquiry_id = " + enquiryId;
		con = EdumoreDBConnection.getDBConnection();
		Statement st = null;
		st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		// EnquiryBean bean = new EnquiryBean();
		List<FollowupBean> followupBeans = new ArrayList<FollowupBean>();
		while (rs.next()) {
			FollowupBean bean = new FollowupBean();
			bean.setFollowupId(rs.getInt(1));
			bean.setDate(rs.getDate(2));
			bean.setRemarks(rs.getString(3));
			bean.setEnquiryId(rs.getString(4));
			followupBeans.add(bean);
		}
		
		return followupBeans;
	}
	

}
