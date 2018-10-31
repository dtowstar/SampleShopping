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
		System.out.print("測試段1");
		System.out.println(session.getAttribute("User_ID"));
		System.out.print("測試段2");
		System.out.println(String.valueOf(session.getAttribute("User_ID")));
		String User_ID = String.valueOf(session.getAttribute("User_ID"));
		if ((User_ID!= null) || (User_ID=="")){
			if (cartDAO.ishascart(User_ID, pid)) {
				response.setContentType("text/html;charset=UTF-8"); 
				response.getWriter().println("<script>alert('商品已加入購物車'); window.location='PD.jsp?pid="+ pid +"' </script>");
			}else{
				cartDAO.addcart(User_ID, pid, quantity);
				response.setContentType("text/html;charset=UTF-8");
				response.getWriter().println("<script>alert('成功加入購物車'); window.location='PDlist.jsp' </script>");
			}
		}else{
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().println("<script>alert('請先登入會員'); window.location='PDlist.jsp' </script>");
		
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
