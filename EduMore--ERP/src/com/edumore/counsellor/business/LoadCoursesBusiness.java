package com.edumore.counsellor.business;

import java.sql.SQLException;
import java.util.ArrayList;

import com.edumore.admin.bean.CourseBean;
import com.edumore.counsellor.dao.LoadCoursesDAO;

public class LoadCoursesBusiness {

	public ArrayList<CourseBean> loadCourses() throws SQLException,
			ClassNotFoundException {
		return new LoadCoursesDAO().loadCourses();
	}

}
