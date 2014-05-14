package com.edumore.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.edumore.admin.bean.AdminLoginBean;
import com.edumore.admin.service.AdminLoginBusiness;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminLogin() {
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
		
		AdminLoginBean loginBean = new AdminLoginBean();
		AdminLoginBusiness loginBusiness = new AdminLoginBusiness();
		boolean isAuthorisedUser = false;
		
		loginBean.setUsername(request.getParameter("username"));
		loginBean.setPassword(request.getParameter("password"));
		try {
			isAuthorisedUser = loginBusiness.isAuthorisedUser(loginBean);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession httpSession = request.getSession();
		if(isAuthorisedUser){
			httpSession.setAttribute("username", loginBean.getUsername());
			RequestDispatcher rd = request.getRequestDispatcher("adminHome.jsp");
			rd.forward(request, response);
		}else{
			httpSession.setAttribute("status", "Invalid Login details. Please try again");
			RequestDispatcher rd = request.getRequestDispatcher("adminLogin.jsp");
			rd.forward(request, response);
		}
		
		// response.sendRedirect("adminHome.jsp");
	}
}
