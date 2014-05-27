package com.edumore.counsellor.business;

import java.sql.SQLException;
import java.util.List;

import com.edumore.counsellor.bean.FollowupBean;
import com.edumore.counsellor.dao.FollowupDAO;

public class FollowupBusiness {

	public static boolean addFollowup(FollowupBean followupBean, String admissionStatus, String enquiryStatus) throws SQLException, ClassNotFoundException {
		return FollowupDAO.addFollowup(followupBean,admissionStatus ,enquiryStatus);
	}

	public static List<FollowupBean> listFollowup(String enquiryId) throws SQLException, ClassNotFoundException {
		
		return FollowupDAO.listFollowup(enquiryId);
	}

}
