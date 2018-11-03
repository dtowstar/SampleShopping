package com.SampleShopping.servlet;

import java.io.IOException;

import shoppingCartCommand.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import shoppingCartCommand.invoker;//4
import shoppingCartCommand.deletecartCommand;//8
/**
 * Servlet implementation class deletecart
 */
@WebServlet("/deletecart")
public class deletecart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletecart() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String ShopID =  String.valueOf(request.getParameter("Shop_ID"));
		invoker Invoker = invoker.createInvoker();
		deletecartCommand DCCI = new deletecartCommand(ShopID);
		Invoker.storeAndExecute(DCCI);
		response.sendRedirect("shopcart.jsp");
	}
	
}
