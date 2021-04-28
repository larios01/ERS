package com.larissa.ers.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.larissa.ers.resolved.*;

/**
 * Servlet implementation class Approve
 */
public class Approve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Approve() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String status = "Approved";
		
		HttpSession session = request.getSession();
		String employee = (String) session.getAttribute("employee");
		int amount = (int) session.getAttribute("amt");
		int reqId = (int) session.getAttribute("reqId");
		
		Boolean check = reqA(status, employee, amount, reqId);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		if(check == true) {
			out.println("<html><body>"
					+ "<p>The Request has been Resolved</p>"
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
	public Boolean reqA(String status, String employee, int amount, int reqId) {
		ResolvedDAOImpl rDAO = new ResolvedDAOImpl();
		Resolved p = new Resolved(status, employee, amount, reqId);
		Boolean check = rDAO.insertIntoRequest(p);
		return check;
	}
	

}
