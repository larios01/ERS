package com.larissa.ers.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Random;

import com.larissa.ers.pending.*;

/**
 * Servlet implementation class NewRequest
 */
public class NewRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Random r = new Random();
		int rand = r.nextInt(100);
		String employee = request.getParameter("username");
		String amount = request.getParameter("amount");
		int amt = Integer.parseInt(amount);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();	
		
		Boolean check = newRequest(rand, employee, amt);
		
		if(check == true) {
			out.println("<html><body>"
					+ "<p>Your request was submitted</p>"
					+ "<p> </p>"
					+ "<form action=\"index.jsp\"> <input type =\"Submit\" value=\"Logout\"></form>"
					+ "<p> </p>"
					+ "</body></html>");
			
			
		}
		else {
			out.println("Something went wrong,"
					+ "Try again!");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public static Boolean newRequest(int rand, String employee, int amt) {
		PendingDAOImpl pDAO = new PendingDAOImpl();
		Pending p = new Pending(rand, employee, amt);
		p.getReqId();
		p.getEmployee();
		p.getAmount();
		Boolean check = pDAO.insertIntoRequest(p);
		return check;
	}
	
	

}
