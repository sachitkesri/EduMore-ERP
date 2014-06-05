package com.edumore.home.business;

import java.sql.SQLException;

import com.edumore.admin.bean.UserBean;
import com.edumore.home.dao.LoginDAO;

public class LoginBusiness {

	public static UserBean verifyLogin(String username, String password) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return LoginDAO.verifyLogin(username,password);
	}

}
