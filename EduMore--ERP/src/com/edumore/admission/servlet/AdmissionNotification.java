package com.edumore.admission.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.edumore.admission.business.AdmissionNotificationDBusiness;

/**
 * Servlet implementation class AdmissionNotification
 */
@WebServlet("/loadPendingAdmission")
public class AdmissionNotification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdmissionNotification() {
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
		try {
			ArrayList<String> enquiryNumbers = new AdmissionNotificationDBusiness().fetchRegistrations();
			System.out.println(enquiryNumbers.size());
			JSONArray enquiryNumbersListJSON = new JSONArray();
			JSONObject responseJSONObject = new JSONObject();
			for(String enquiryNumber : enquiryNumbers){
				System.out.println(enquiryNumber);
				enquiryNumbersListJSON.add(enquiryNumber);
			}
			responseJSONObject.put("enquiryNumbersList", enquiryNumbersListJSON);
			response.getWriter().write(responseJSONObject.toString());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
