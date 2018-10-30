package com.SampleShopping.servlet;

import java.io.IOException;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Session;

/**
 * Servlet implementation class logout
 */
@WebServlet("/logout")
public class logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String User_ID_Session="",User_Name_Session="" ;
		System.out.println(User_ID_Session + User_Name_Session);
		HttpSession session = request.getSession(true);
		User_ID_Session = String.valueOf(session.getAttribute("User_ID"));
		User_Name_Session = (String)session.getAttribute("User_Name");
		System.out.println(User_ID_Session + User_Name_Session);
		session.setAttribute("User_ID","");
		session.setAttribute("User_Name","");
		response.sendRedirect("PDlist.jsp");
		//session.removeAttribute("User_ID");
		//session.removeAttribute("User_Name");
		//System.out.println(User_ID_Session + User_Name_Session);
		//request.getRequestDispatcher("../PDlist.jsp").forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
