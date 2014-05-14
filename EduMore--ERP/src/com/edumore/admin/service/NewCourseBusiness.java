package com.edumore.admin.service;

import java.sql.SQLException;

import com.edumore.admin.bean.CourseBean;
import com.edumore.admin.dao.NewCourseDAO;

public class NewCourseBusiness {
	
	NewCourseDAO courseDAO = new NewCourseDAO();
	
	public boolean insertNewCourse(CourseBean courseBean) throws SQLException, ClassNotFoundException {
		boolean isCourseAdded = courseDAO.insertNewCourse(courseBean);
		return isCourseAdded;
	}

}
