package com.edumore.counsellor.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edumore.admin.bean.CourseBean;
import com.edumore.databseconnection.EdumoreDBConnection;

public class LoadCoursesDAO {

	private Connection con;

	public ArrayList<CourseBean> loadCourses() throws SQLException, ClassNotFoundException {
		String query = "SELECT * FROM course_details";
		con = EdumoreDBConnection.getDBConnection();
		Statement st = null;
		st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		List<CourseBean> courseBeans = new ArrayList<CourseBean>();
		while (rs.next()) {
			CourseBean bean = new CourseBean();
			bean.setCourseId(rs.getInt(1));
			bean.setCourseTitle(rs.getString(2));
			courseBeans.add(bean);
		}

		return (ArrayList<CourseBean>) courseBeans;
	}

}
