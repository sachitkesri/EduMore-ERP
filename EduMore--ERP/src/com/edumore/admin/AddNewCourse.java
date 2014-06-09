package com.edumore.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
@WebServlet("/admin/AddCourse")
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
		courseBean.setCourseTitle(request.getParameter("courseTitle").toString());
		courseBean.setCourseDuration(Integer.parseInt(request.getParameter("courseDuration").toString()));
		courseBean.setCourseFee(Long.parseLong(request.getParameter("courseFee").toString()));
		courseBean.setAdminId(Integer.parseInt(httpSession.getAttribute("userLoginId").toString()));
		NewCourseBusiness courseBusiness = new NewCourseBusiness();

		try {
			courseBusiness.insertNewCourse(courseBean);
			request.setAttribute("statusMsg", "Course Added Successfully");
			request.setAttribute("statusMsgColor", "green");
			RequestDispatcher rd = request.getRequestDispatcher("newCourse.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			request.setAttribute("statusMsg", "Some error occured. Try again!!");
			request.setAttribute("statusMsgColor", "red");
			e.printStackTrace();
		}
	}

}
