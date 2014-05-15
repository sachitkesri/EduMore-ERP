package com.edumore.counsellor.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edumore.counsellor.bean.EnquiryBean;
import com.edumore.counsellor.business.EditEnquiryBusiness;

/**
 * Servlet implementation class EditEnquiry
 */
@WebServlet("/EditEnquiry")
public class EditEnquiry extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditEnquiry() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		new EditEnquiry().doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String enquiryId = request.getParameter("enquiryId");
		EnquiryBean enquiryBean = new EditEnquiryBusiness().editEnquiry(enquiryId);

	}

}
