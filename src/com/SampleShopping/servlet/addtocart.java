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
 * Servlet implementation class shopcart
 */
@WebServlet("/shopcart")
public class addtocart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addtocart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String quantity = String.valueOf(request.getParameter("Quantity"));
		String pid =  String.valueOf(request.getParameter("pid"));
		HttpSession session = request.getSession(true);
		String User_ID = String.valueOf(session.getAttribute("User_ID"));
		if (cartDAO.ishascart(User_ID, pid)) {
			System.out.println("4");
			response.setContentType("text/html;charset=UTF-8"); 
			response.getWriter().println("<script>alert('商品已加入購物車'); window.location='PD.jsp?pid="+ pid +"' </script>");
		}else{
			System.out.println("5");
			cartDAO.addcart(User_ID, pid, quantity);
		}
		System.out.println("6");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println("<script>alert('成功加入購物車'); window.location='PDlist.jsp' </script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
