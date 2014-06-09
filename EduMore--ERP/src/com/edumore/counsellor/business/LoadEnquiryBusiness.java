package com.edumore.counsellor.business;

import java.sql.SQLException;

import com.edumore.counsellor.bean.EnquiryBean;
import com.edumore.counsellor.dao.LoadEnquiryDAO;

public class LoadEnquiryBusiness {

	public EnquiryBean loadEnquiry(String enquiryNumber) throws SQLException, ClassNotFoundException {
		return new LoadEnquiryDAO().loadEnquiry(enquiryNumber);
	}

}
