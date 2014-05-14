package com.edumore.counsellor;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edumore.admin.AdminLogin;
import com.edumore.counsellor.bean.Address;
import com.edumore.counsellor.bean.EnquiryBean;
import com.edumore.counsellor.business.EnquiryBusiness;

/**
 * Servlet implementation class NewEnquiry
 */
@WebServlet("/NewEnquiry")
public class NewEnquiry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewEnquiry() {
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
		EnquiryBean enquiryBean = new EnquiryBean();
		EnquiryBusiness enquiryBusiness = new EnquiryBusiness();
		
		enquiryBean.setFirstName(request.getParameter("firstName"));
		enquiryBean.setMiddleName(request.getParameter("middleName"));
		enquiryBean.setLastName(request.getParameter("lastName"));
		enquiryBean.setDateOfBirth(request.getParameter("dateOfBirth"));
		enquiryBean.setGender(request.getParameter("gender"));
		enquiryBean.setEmailId(request.getParameter("emailId"));
		enquiryBean.setResidenceNumber(request.getParameter("residenceNumber"));
		enquiryBean.setMobileNumber(request.getParameter("mobileNumber"));
		enquiryBean.setFatherFirstName(request.getParameter("fatherFirstName"));
		enquiryBean.setFatherMiddleName(request.getParameter("fatherMiddleName"));
		enquiryBean.setFatherLastName(request.getParameter("fatherLastName"));
		enquiryBean.setFatherResidenceNumber(request.getParameter("fatherResidenceNumber"));
		enquiryBean.setFatherMobileNumber(request.getParameter("fatherMobileNumber"));
		
		Address currentAddress = new Address();
		currentAddress.setHouseNumber(request.getParameter("currentHouseNumber"));
		currentAddress.setBuildingName(request.getParameter("currentBuildingName"));
		currentAddress.setRoadName(request.getParameter("currentRoadName"));
		currentAddress.setAreaDetail(request.getParameter("currentAreaDetail"));
		currentAddress.setCity(request.getParameter("currentCity"));
		currentAddress.setState(request.getParameter("currentState"));
		currentAddress.setPincode(request.getParameter("currentPincode"));
		
		Address permanentAddress = new Address();
		permanentAddress.setHouseNumber(request.getParameter("permanentHouseNumber"));
		permanentAddress.setBuildingName(request.getParameter("permanentBuildingName"));
		permanentAddress.setRoadName(request.getParameter("permanentRoadName"));
		permanentAddress.setAreaDetail(request.getParameter("permanentAreaDetail"));
		permanentAddress.setCity(request.getParameter("permanentCity"));
		permanentAddress.setState(request.getParameter("permanentState"));
		permanentAddress.setPincode(request.getParameter("permanentPincode"));
		
		enquiryBean.setCurrentAddress(currentAddress);
		enquiryBean.setPermanentAddress(permanentAddress);
		
		enquiryBean.setEnquiryNumber(System.currentTimeMillis());
		boolean isAdded = false;
		try {
			isAdded = enquiryBusiness.addNewEnquiry(enquiryBean);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(isAdded){
			request.setAttribute("statusMsg", "Saved Successfully");
		}else{
			request.setAttribute("statusMsg", "Some Error occur while saving");
		}
		RequestDispatcher rd = request.getRequestDispatcher("addNewEnquiry.jsp");
		rd.forward(request, response);
		
	}

}
