package com.edumore.admin.service;

import java.sql.SQLException;

import com.edumore.admin.bean.AdminLoginBean;
import com.edumore.admin.dao.AdminLoginDAO;

public class AdminLoginBusiness {
	
	AdminLoginDAO adminLoginDAO = new AdminLoginDAO();
	public boolean isAuthorisedUser(AdminLoginBean loginBean) throws SQLException, ClassNotFoundException{
		AdminLoginBean loginBeanDAO = new AdminLoginBean();
		loginBeanDAO = adminLoginDAO.selectAdminLoginCrendetials(loginBean);
		if((loginBeanDAO.getUsername().equals(loginBean.getUsername())) && (loginBeanDAO.getPassword().equals(loginBean.getPassword()))){
			return true;
		}else{
			return false;
		}
	}
}
