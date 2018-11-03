package com.SampleShopping.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoppingCartCommand.restore;//1

/**
 * Servlet implementation class useRestores
 */
@WebServlet("/useRestores")
public class useRestores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public useRestores() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		restore.useRestore();
		System.out.println("do restore");
		response.sendRedirect("shopcart.jsp");
	}
}
