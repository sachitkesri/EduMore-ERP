package com.edumore.counsellor.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edumore.counsellor.bean.EnquiryBean;
import com.edumore.counsellor.business.LoadEnquiryBusiness;

/**
 * Servlet implementation class LoadEnquiryServlet
 */
@WebServlet("/academic/LoadEnquiry")
public class LoadEnquiryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoadEnquiryServlet() {
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
		String enquiryNumber = request.getParameter("enquiryNumber").toString();
		EnquiryBean enquiryBean = null;
		try {
			enquiryBean = new LoadEnquiryBusiness().loadEnquiry(enquiryNumber);
			if (enquiryBean != null) {
				request.setAttribute("enquiry", enquiryBean);
			} else {
				request.setAttribute("loadEnquiryStatusMsg", "No enquiry found");
				request.setAttribute("loadEnquiryStatusMsgColor", "red");
			}

		} catch (Exception e) {
			request.setAttribute("loadEnquiryStatusMsg",
					"Error occured while loading enquiries");
			request.setAttribute("loadEnquiryStatusMsgColor", "red");
		} finally {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("admissionForm.jsp");
			dispatcher.forward(request, response);
		}

	}
}
