package com.edumore.counsellor.business;

import com.edumore.counsellor.bean.EnquiryBean;
import com.edumore.counsellor.dao.EditEnquiryDAO;

public class EditEnquiryBusiness {

	public EnquiryBean editEnquiry(String enquiryId) {
		return new EditEnquiryDAO().editEnquiry();
	}

}
