package com.edumore.counsellor.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edumore.counsellor.bean.RegistrationBean;
import com.edumore.counsellor.business.RegistrationBusiness;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/counsellor/register")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Registration() {
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
		try {
			RegistrationBean registrationBean = new RegistrationBean();
			registrationBean.setEnquiryNumber(request
					.getParameter("enquiryNumber"));
			registrationBean.setRegistrationFee(Float.parseFloat(request
					.getParameter("amount").toString()));
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = new Date(System.currentTimeMillis());
			java.sql.Date date = new java.sql.Date(date1.getTime());
			registrationBean.setRegistrationDate(date);
			boolean isRegisterd = new RegistrationBusiness().registerEnquiry(
					registrationBean, "registration");
			if (isRegisterd) {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("invoce.jsp");
				dispatcher.forward(request, response);
			} else {
				request.setAttribute("registrationStatusMsgColor", "red");
				request.setAttribute(
						"registrationStatusMessage",
						"Some error occured while registering. Please contact administrator or check entered data");
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("registration.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
