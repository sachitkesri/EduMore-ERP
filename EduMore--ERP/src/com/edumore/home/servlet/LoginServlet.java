package com.edumore.home.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.edumore.home.business.LoginBusiness;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		HttpSession httpSession = request.getSession();
		
		String username = request.getParameter("username").toString();
		String password = request.getParameter("password").toString();
		System.out.println(httpSession.getAttribute("loginType").toString());
		int userLoginId = 0;
		try {
			userLoginId = LoginBusiness.verifyLogin(username, password, httpSession.getAttribute("loginType").toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(userLoginId != -1){
			httpSession.setAttribute("userLoginId", userLoginId);
			RequestDispatcher dispatcher = null;
			if(httpSession.getAttribute("loginType").toString().equalsIgnoreCase("admin")){
				dispatcher = request.getRequestDispatcher("adminHome.jsp");
			}else if(httpSession.getAttribute("loginType").toString().equalsIgnoreCase("counsellor")){
				dispatcher = request.getRequestDispatcher("counsellorhome.jsp");
			}else if(httpSession.getAttribute("loginType").toString().equalsIgnoreCase("academic")){
				dispatcher = request.getRequestDispatcher("academichome.jsp");
			}
			dispatcher.forward(request, response);
		}else{
			request.setAttribute("loginStatusMsgColor", "red");
			request.setAttribute("loginStatusMessage", "username or password is incorrect!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
	}

}
