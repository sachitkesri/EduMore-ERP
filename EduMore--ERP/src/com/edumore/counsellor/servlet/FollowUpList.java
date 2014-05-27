package com.edumore.counsellor.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.edumore.counsellor.bean.FollowupBean;
import com.edumore.counsellor.business.FollowupBusiness;

/**
 * Servlet implementation class FollowUpList
 */
@WebServlet("/ListFollowup")
public class FollowUpList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FollowUpList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<FollowupBean> followupBeans = FollowupBusiness.listFollowup(request.getParameter("enquiryId").toString());
			System.out.println(followupBeans.size());
			request.setAttribute("followuplist", followupBeans);
			JSONArray jsonFollowUpList = new JSONArray();
			JSONObject jsonObject = new JSONObject();
			
			for(FollowupBean bean : followupBeans){
				try {
					jsonObject.put("date",String.valueOf(bean.getDate()));
					jsonObject.put("remarks",bean.getRemarks());
					jsonObject.put("enquiryId",bean.getEnquiryId());
					jsonObject.put("followupId",String.valueOf(bean.getFollowupId()));
					jsonFollowUpList.put(jsonObject);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			JSONObject jsonObject2 = new JSONObject();
			try {
				jsonObject2.put("followupList", jsonFollowUpList);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.getWriter().write(jsonObject2.toString());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
