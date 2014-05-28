package com.edumore.admin.service;

import java.sql.SQLException;

import com.edumore.admin.bean.UserBean;
import com.edumore.admin.dao.UserProfileDAO;

public class UserProfileBusiness {

	public boolean addNewUser(UserBean userBean) {
		
		try {
			return new UserProfileDAO().addNewUser(userBean);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
