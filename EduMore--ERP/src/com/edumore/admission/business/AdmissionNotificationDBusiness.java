package com.edumore.admission.business;

import java.sql.SQLException;
import java.util.ArrayList;

import com.edumore.admission.dao.AdmissionNotificationDAO;

public class AdmissionNotificationDBusiness {

	public ArrayList<String> fetchRegistrations() throws SQLException, ClassNotFoundException {
		
		return new AdmissionNotificationDAO().fetchRegistrations();
	}

}
