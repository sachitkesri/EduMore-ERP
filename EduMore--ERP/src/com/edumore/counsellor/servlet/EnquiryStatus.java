package com.edumore.counsellor.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edumore.counsellor.business.FollowupBusiness;

/**
 * Servlet implementation class EnquiryStatus
 */
@WebServlet("/EnquiryStatus")
public class EnquiryStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnquiryStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Test..");
		String enquiryStatus = null;
		try {
			enquiryStatus = FollowupBusiness.checkEnquiryStatus(request.getParameter("enquiryId").toString());
			System.out.println(enquiryStatus);
			if(enquiryStatus != null && enquiryStatus.equalsIgnoreCase("open")){
				response.getWriter().write("open");
			}else{
				response.getWriter().write(enquiryStatus);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
