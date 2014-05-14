package com.edumore.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.edumore.admin.bean.CourseBean;
import com.edumore.admin.service.NewCourseBusiness;

/**
 * Servlet implementation class AddNewCourse
 */
@WebServlet("/AddCourse")
public class AddNewCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddNewCourse() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		CourseBean courseBean = new CourseBean();
		courseBean.setCourseTitle(request.getParameter("courseTitle"));
		courseBean.setAdminUsername((String)httpSession.getAttribute("username"));
		NewCourseBusiness courseBusiness = new NewCourseBusiness();

		try {
			courseBusiness.insertNewCourse(courseBean);
			request.setAttribute("status", "new course added");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
