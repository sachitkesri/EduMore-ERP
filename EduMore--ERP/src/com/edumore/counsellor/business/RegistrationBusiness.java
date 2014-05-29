package com.edumore.counsellor.business;

import java.sql.SQLException;

import com.edumore.counsellor.bean.RegistrationBean;
import com.edumore.counsellor.dao.RegistrationDAO;

public class RegistrationBusiness {

	public boolean registerEnquiry(RegistrationBean registrationBean,
			String type) throws SQLException {
		
		return new RegistrationDAO().registerEnquiry(registrationBean,type);
	}

}
