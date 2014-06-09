package com.edumore.counsellor.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.edumore.admin.bean.CourseBean;
import com.edumore.counsellor.business.LoadCoursesBusiness;

/**
 * Servlet implementation class LoadCourses
 */
@WebServlet("/LoadCourses")
public class LoadCourses extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoadCourses() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ArrayList<CourseBean> courseBeans = new ArrayList<CourseBean>();
		try {
			courseBeans = new LoadCoursesBusiness().loadCourses();
			JSONArray courseList = new JSONArray();
			JSONObject course = new JSONObject();
			System.out.println(courseBeans.size());
			for (CourseBean courseBean : courseBeans) {
				course.put(courseBean.getCourseId(), courseBean.getCourseTitle());
			}
			courseList.add(course);
			JSONObject course2 = new JSONObject();
			course2.put("courseList", courseList);
			response.getWriter().write(course.toJSONString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
