package com.edumore.counsellor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edumore.counsellor.bean.EnquiryBean;
import com.edumore.counsellor.business.EnquiryBusiness;

/**
 * Servlet implementation class EnquiryList
 */
@WebServlet("/counsellor/EnquiryList")
public class EnquiryList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnquiryList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		new EnquiryList().doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<EnquiryBean> enquiryList = new ArrayList<EnquiryBean>();
		try {
			enquiryList = new EnquiryBusiness().listAllEnquiries();
			request.setAttribute("list", enquiryList);
			System.out.println(request.getContextPath());
			RequestDispatcher dis =  request.getRequestDispatcher("enquirylist.jsp");
			dis.forward(request, response); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
