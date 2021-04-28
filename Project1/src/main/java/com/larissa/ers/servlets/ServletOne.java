package com.larissa.ers.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.larissa.ers.connection.*;
import com.larissa.ers.employee.*;
import com.larissa.ers.manager.*;
import com.larissa.ers.resolved.*;
import com.larissa.ers.pending.*;

/**
 * Servlet implementation class ServletOne
 */
public class ServletOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("PostgreSQL Unable to load JDBC Driver");
		}
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Employee Login
		Employee emp = new Employee();
		EmployeeDAOImplement eDAO = new EmployeeDAOImplement();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		emp = eDAO.selectEmployee(username);
		String user = emp.getUsername();
		String epass = emp.getPass();
		String enam = emp.getNam();		
		
		HttpSession session = request.getSession();
		session.setAttribute("uss", username);
		session.setAttribute("username", user);
		session.setAttribute("pass", epass);
		session.setAttribute("nam", enam);
		//set attribute
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();	
		
		boolean ch_u = username.equals(user);
		boolean ch_p = password.equals(epass);
		
		if(ch_u == true && ch_p == true) {
			out.println("Got it");
			RequestDispatcher rd = request.getRequestDispatcher("EmployeeHome");
			rd.forward(request, response);
			
		}
		else {
			out.println("Try again!");
		}
		
	}

	private void setAttribute(HttpSession session) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
