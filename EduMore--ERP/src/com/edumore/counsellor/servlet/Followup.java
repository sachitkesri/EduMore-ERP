package com.edumore.counsellor.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FollowupBean followupBean = new FollowupBean();
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		String admissionStatus = request.getParameter("admissionstatus");
		String enquiryStatus = "open";
		if(request.getParameter("enquirystatus") != null){
			enquiryStatus = request.getParameter("enquirystatus");
		}
		System.out.println(enquiryStatus);
		try {
			java.sql.Date date = new java.sql.Date(df.parse(request.getParameter("date").toString()).getTime());
			followupBean.setDate(date);
			followupBean.setRemarks(request.getParameter("remarks").toString());
			followupBean.setEnquiryId(request.getParameter("enquiryId").toString());
			boolean isSaved = FollowupBusiness.addFollowup(followupBean,admissionStatus,enquiryStatus);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
