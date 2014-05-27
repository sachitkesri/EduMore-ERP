package com.edumore.counsellor.business;

import java.sql.SQLException;

import com.edumore.counsellor.bean.EnquiryBean;
import com.edumore.counsellor.dao.EditEnquiryDAO;

public class EditEnquiryBusiness {

	public EnquiryBean editEnquiry(String enquiryId) throws SQLException, ClassNotFoundException {
		return new EditEnquiryDAO().editEnquiry(enquiryId);
	}

}

