package com.edumore.counsellor.business;

import java.sql.SQLException;
import java.util.List;

import com.edumore.counsellor.bean.EnquiryBean;
import com.edumore.counsellor.dao.EnquiryListDAO;
import com.edumore.counsellor.dao.NewEnquiryDAO;

public class EnquiryBusiness {

	public boolean addNewEnquiry(EnquiryBean enquiryBean) throws SQLException, ClassNotFoundException {
		return new NewEnquiryDAO().addNewEnquiry(enquiryBean);
	}

	public List<EnquiryBean> listAllEnquiries() throws SQLException, ClassNotFoundException {
		
		return new EnquiryListDAO().listEnquiries();
	}
	
	public boolean updateEnquiry(EnquiryBean enquiryBean) throws SQLException, ClassNotFoundException {
		return new NewEnquiryDAO().updateEnquiry(enquiryBean);
	}

}
