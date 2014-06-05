package com.edumore.counsellor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edumore.counsellor.bean.Address;
import com.edumore.counsellor.bean.EducationalQualification;
import com.edumore.counsellor.bean.EnquiryBean;
import com.edumore.counsellor.business.EnquiryBusiness;

/**
 * Servlet implementation class NewEnquiry
 */
@WebServlet("/counsellor/NewEnquiry")
public class Enquiry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Enquiry() {
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
		ArrayList<EducationalQualification> educationalQualifications = new ArrayList<EducationalQualification>();
		int noOfEducations = Integer.parseInt(request.getParameter("educationNumber").toString());
		System.out.println(noOfEducations);
		for(int i = 0; i <= noOfEducations; i++){
			EducationalQualification qualification = new EducationalQualification();
			qualification.setQualification(request.getParameter("qualification_"+i).toString());
			qualification.setCollege(request.getParameter("schoolName_"+i).toString());
			qualification.setCompletedYear(request.getParameter("completedYear_"+i).toString());
			qualification.setStatus(request.getParameter("status_"+i).toString());
			qualification.setUnversity(request.getParameter("board_"+i).toString());
			qualification.setGrade(request.getParameter("marksSecured_"+i).toString());
			educationalQualifications.add(qualification);
		}
		enquiryBean.setEducationalQualifications(educationalQualifications);
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
		currentAddress.setBuildingName(request.getParameter("currentBuilding"));
		currentAddress.setRoadName(request.getParameter("currentRoad"));
		currentAddress.setAreaDetail(request.getParameter("currentArea"));
		currentAddress.setCity(request.getParameter("currentCity"));
		currentAddress.setState(request.getParameter("currentState"));
		currentAddress.setPincode(request.getParameter("currentPincode"));
		
		Address permanentAddress = new Address();
		permanentAddress.setHouseNumber(request.getParameter("permanentHouseNumber"));
		permanentAddress.setBuildingName(request.getParameter("permanentBuilding"));
		permanentAddress.setRoadName(request.getParameter("permanentRoad"));
		permanentAddress.setAreaDetail(request.getParameter("permanentrArea"));
		permanentAddress.setCity(request.getParameter("permanentCity"));
		permanentAddress.setState(request.getParameter("permanentState"));
		permanentAddress.setPincode(request.getParameter("permanentPincode"));
		
		enquiryBean.setCurrentAddress(currentAddress);
		enquiryBean.setPermanentAddress(permanentAddress);
		
		boolean isAdded = false;
		try {
			if(request.getParameter("action").toString().equalsIgnoreCase("addNewEnquiry")){
				enquiryBean.setEnquiryNumber(System.currentTimeMillis());
				isAdded = enquiryBusiness.addNewEnquiry(enquiryBean);
			}else if(request.getParameter("action").toString().equalsIgnoreCase("updateEnquiry")){
				enquiryBean.setEnquiryNumber(Long.parseLong(request.getParameter("enquiryNumber").toString()));
				enquiryBean.setEnquiry_id(Integer.parseInt(request.getParameter("enquiryId").toString()));
				isAdded = enquiryBusiness.updateEnquiry(enquiryBean);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(isAdded){
			request.setAttribute("statusMsg", "Saved Successfully");
			request.setAttribute("statusMsgColor", "green");
		}else{
			request.setAttribute("statusMsg", "Some Error occur while saving");
			request.setAttribute("statusMsgColor", "red");
		}
		RequestDispatcher rd = request.getRequestDispatcher("addNewEnquiry.jsp");
		rd.forward(request, response);
		
	}

}
