package com.edumore.counsellor.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edumore.counsellor.bean.FollowupBean;
import com.edumore.counsellor.business.FollowupBusiness;

/**
 * Servlet implementation class Followup
 */
@WebServlet("/Followup")
public class Followup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Followup() {
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
		String enquiryStatus = null;
		FollowupBean followupBean = new FollowupBean();
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		String admissionStatus = request.getParameter("admissionstatus");
		System.out.println("request.getParameter('enquirystatus') : " + request.getParameter("enquirystatus"));
		if (request.getParameter("enquirystatus") != null) {
			enquiryStatus = request.getParameter("enquirystatus");
		}else{
			enquiryStatus = "open";
		}
		System.out.println(enquiryStatus);
		try {
			java.sql.Date date = new java.sql.Date(df.parse(
					request.getParameter("date").toString()).getTime());
			followupBean.setDate(date);
			followupBean.setRemarks(request.getParameter("remarks").toString());
			followupBean.setEnquiryId(request.getParameter("enquiryId")
					.toString());
			boolean isSaved = FollowupBusiness.addFollowup(followupBean,
					admissionStatus, enquiryStatus);
			System.out.println(isSaved);
			if (isSaved) {
				request.setAttribute("follwupStatusMsgColor", "green");
				request.setAttribute("follwupStatusMessage", "followup added.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/EnquiryList");
				dispatcher.forward(request, response);
			} else {
				request.setAttribute("follwupStatusMsgColor", "red");
				request.setAttribute("follwupStatusMessage", "Some error occured in adding followup. Please try again.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/EnquiryList");
				dispatcher.forward(request, response);
			}

		} catch (Exception e) {
			request.setAttribute("follwupStatusMsgColor", "red");
			request.setAttribute("follwupStatusMessage", "Some error occured in adding followup. Please try again.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/EnquiryList");
			dispatcher.forward(request, response);
			e.printStackTrace();
		}

	}

}
