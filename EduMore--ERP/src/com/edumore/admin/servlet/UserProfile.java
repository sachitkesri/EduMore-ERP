package com.edumore.admin.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edumore.admin.bean.UserBean;
import com.edumore.admin.service.UserProfileBusiness;

/**
 * Servlet implementation class UserProfile
 */
@WebServlet("/admin/UserProfile")
public class UserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProfile() {
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
		System.out.println("Test App&&");
		try {
			UserBean userBean = new UserBean();
			userBean.setName(request.getParameter("name").toString());
			userBean.setRole(request.getParameter("role").toString());
			userBean.setEmail(request.getParameter("email").toString());
			userBean.setContactNumber(request.getParameter("contactNumber").toString());
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date dateOfjoining = new Date(df.parse(request.getParameter("dateOfJoining").toString()).getTime());
			userBean.setDateOfJoining(dateOfjoining);
			userBean.setAddress(request.getParameter("address").toString());
			userBean.setUsername(request.getParameter("username").toString());
			userBean.setPassword(request.getParameter("password").toString());
			boolean isSaved = false;
			if(request.getParameter("action").toString().equalsIgnoreCase("addNewUser")){
				isSaved = new UserProfileBusiness().addNewUser(userBean);
				if(isSaved){
					request.setAttribute("userAdditionStatusMsgColor", "green");
					request.setAttribute("userAdditionStatusMessage", "New user added successfully");
					RequestDispatcher rd = request.getRequestDispatcher("newuser.jsp");
					rd.forward(request, response);
				}
			}
			
		} catch (ParseException e) {
			request.setAttribute("userAdditionStatusMsgColor", "red");
			request.setAttribute("userAdditionStatusMessage", "Please enter date in a format YYYY-MM-DD");
			RequestDispatcher rd = request.getRequestDispatcher("newuser.jsp");
			rd.forward(request, response);
		}catch (Exception e) {
			request.setAttribute("userAdditionStatusMsgColor", "red");
			request.setAttribute("userAdditionStatusMessage", "Some Error occured while saving");
			RequestDispatcher rd = request.getRequestDispatcher("newuser.jsp");
			rd.forward(request, response);
		}
		
	}

}
