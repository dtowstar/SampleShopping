package com.SampleShopping.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoppingCartCommand.command;
import shoppingCartCommand.deletecartCommand;
import shoppingCartCommand.invoker;
import shoppingCartCommand.updatePD_QuantityCommand;

/**
 * Servlet implementation class changeCPQ
 */
@WebServlet("/changeCPQ")
public class changeCPQ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changeCPQ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String ShopID =  String.valueOf(request.getParameter("Shop_ID"));
		String PQuantity = String.valueOf(request.getParameter("P_Quantity"));
		System.out.println(ShopID);
		System.out.println(PQuantity);
		int s = Integer.parseInt(ShopID);
		int q = Integer.parseInt(PQuantity);
		invoker Invoker = invoker.createInvoker();
		command UCPQ = new updatePD_QuantityCommand(s,q);
		Invoker.storeAndExecute(UCPQ);
		response.sendRedirect("shopcart.jsp");
	}
}
