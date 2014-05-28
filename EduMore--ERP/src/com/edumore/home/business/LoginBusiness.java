package com.edumore.home.business;

import java.sql.SQLException;

import com.edumore.home.dao.LoginDAO;

public class LoginBusiness {

	public static int verifyLogin(String username, String password, String loginType) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return LoginDAO.verifyLogin(username,password,loginType);
	}

}
