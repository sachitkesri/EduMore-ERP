package com.edumore.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.edumore.admin.bean.CourseBean;
import com.edumore.databseconnection.EdumoreDBConnection;

public class NewCourseDAO {

	private static Connection con;

	public boolean insertNewCourse(CourseBean courseBean) throws SQLException,
			ClassNotFoundException {
		con = (Connection) EdumoreDBConnection.getDBConnection();
		String sql = "insert into course_details(course_title,course_fee,course_duration , admin_id) values(?,?,?,(SELECT user_id FROM user_details WHERE user_id=\""
				+ courseBean.getAdminId() + "\"))";
		PreparedStatement statement = (PreparedStatement) con
				.prepareStatement(sql);
		statement.setString(1, courseBean.getCourseTitle());
		statement.setLong(2, courseBean.getCourseFee());
		statement.setInt(3, courseBean.getCourseDuration());
		int updated = statement.executeUpdate();
		if (updated == 1) {
			return true;
		} else
			return false;

	}

}
