package com.SampleShopping.servlet;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.usersDAO;//8

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String account =request.getParameter("TB_User_Acc");
		String password =request.getParameter("TB_User_Pwd");
		String rePwd =request.getParameter("TB_User_rePwd");
		String Name =request.getParameter("TB_User_Name");
		String Email =request.getParameter("TB_User_Email");
		String Address =request.getParameter("TB_User_Address");
		HttpSession session = request.getSession(true);
		if(password.equals(rePwd)) {
			try {
				usersDAO.insertUser(account,password,Name,Email,Address);
				session.setAttribute("User_ID",usersDAO.getUser_Infor(account, password, "User_ID"));
				session.setAttribute("User_Name",usersDAO.getUser_Infor(account, password, "User_Name"));
				response.sendRedirect("PDlist.jsp");
			}catch(Exception e) {
				response.setContentType("text/html;charset=UTF-8"); 
				response.getWriter().println("<script>alert('已註冊'); window.location='regedit.jsp' </script>");
			}
		}else {
			response.setContentType("text/html;charset=UTF-8"); 
			response.getWriter().println("<script>alert('重複密碼輸入錯誤'); window.location='regedit.jsp' </script>");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
