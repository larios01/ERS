package com.larissa.ers.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.larissa.ers.pending.Pending;
import com.larissa.ers.pending.PendingDAOImpl;

/**
 * Servlet implementation class Resolve
 */
public class Resolve extends HttpServlet {
	private static final long serialVersionUID = 1L;
 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("user");
		
		PendingDAOImpl pDAO = new PendingDAOImpl();
		Pending check = pDAO.selectRequest(user);
		int id = check.getReqId();
		String e = check.getEmployee();
		int a = check.getAmount();
		
		HttpSession session = request.getSession();
		session.setAttribute("employee", e);
		session.setAttribute("reqId", id);
		session.setAttribute("amt", a);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();	
		
		out.print("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "  <title>Login Page</title>\r\n"
				+ "  <meta charset=\"utf-8\">\r\n"
				+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
				+ "  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\r\n"
				+ "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n"
				+ "  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\r\n"
				+ "  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "\r\n"
				+ "<div class=\"jumbotron text-center\">\r\n"
				+ "  <h1>Resolve Pending Requests</h1>\r\n"
				+ "		<p>Employee: </p>" + e
				+ "		<p>Amount: </p>" + a
				+ "		<form action=\"Approve\"> <input type =\"Submit\" value=\"Approve\"></form>"
				+ "		<form action=\"Deny\"> <input type =\"Submit\" value=\"Deny\"></form>"
				+ "</div>\r\n"
				+ "<form action=\"index.jsp\"> <input type =\"Submit\" value=\"Logout\"></form>"
				+ "</body>\r\n"
				+ "</html>");
		
	
		
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
