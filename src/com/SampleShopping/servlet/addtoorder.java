package com.SampleShopping.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.*;
import java.util.*;
import model.*;
/**
 * Servlet implementation class addtoorder
 */
@WebServlet("/addtoorder")
public class addtoorder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addtoorder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Payment = request.getParameter("paymethod");
		String Invoice = request.getParameter("Invoice");
		HttpSession session = request.getSession(true);
		ArrayList<cart> cartlists = cartDAO.getCartByUser_ID(Integer.parseInt(String.valueOf(session.getAttribute("User_ID")))); 
		for (cart cartlist : cartlists) {
			orderDAO.addorder(String.valueOf(cartlist.getUser_ID()),String.valueOf(cartlist.getPD_ID()), String.valueOf(cartlist.getShop_Quantity()), Payment, Invoice);
			cartDAO.deleteCart(cartlist.getShop_ID());
			productsDAO.updatePD_Quantity(cartlist.getPD_ID(),Integer.parseInt(productsDAO.getPD_Infor(String.valueOf(cartlist.getPD_ID()), "PD_Quantity"))-cartlist.getShop_Quantity());
		}
		response.setContentType("text/html;charset=UTF-8"); 
		response.getWriter().println("<script>alert('已完成結帳，謝謝惠顧。'); window.location='PDlist.jsp' </script>");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
