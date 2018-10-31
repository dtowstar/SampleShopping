package com.SampleShopping.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.*;


/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			String account =request.getParameter("TB_User_Acc");
			String password =request.getParameter("TB_User_Pwd");
			HttpSession session = request.getSession(true);
			boolean loginSuccess=false;
			loginSuccess=usersDAO.confirmUserLogin(account, password);
			if(loginSuccess==true){
				session.setAttribute("User_ID",usersDAO.getUser_Infor(account, password, "User_ID"));
				session.setAttribute("User_Name",usersDAO.getUser_Infor(account, password, "User_Name"));
				response.sendRedirect("PDlist.jsp");
			}else{
				
				response.setContentType("text/html;charset=UTF-8"); 
				response.getWriter().println("<script>alert('登入失敗'); window.location='PDlist.jsp' </script>");
				
			}
			
		}catch(Exception e){ System.out.println(e.getMessage());}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
