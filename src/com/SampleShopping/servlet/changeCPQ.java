package com.SampleShopping.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoppingCartCommand.command;
import shoppingCartCommand.invoker;//4
import shoppingCartCommand.updatePD_QuantityCommand;//4

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
