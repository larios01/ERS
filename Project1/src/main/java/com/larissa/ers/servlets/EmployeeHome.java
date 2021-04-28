package com.larissa.ers.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.larissa.ers.employee.Employee;
import com.larissa.ers.employee.EmployeeDAOImplement;
import com.larissa.ers.pending.*;
import com.larissa.ers.resolved.*;

/**
 * Servlet implementation class EmployeeHome
 */
public class EmployeeHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee emp = new Employee();
		EmployeeDAOImplement eDAO = new EmployeeDAOImplement();
		
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("uss");
		
		emp = eDAO.selectEmployee(name);
		String user = emp.getUsername();
		String epass = emp.getPass();
		String enam = emp.getNam();
		
		Pending requests = viewEmployeeReq(user);
		Resolved res = viewEmployeeRes(user);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "  <title>Login Page</title>\r\n"
				+ "  <meta charset=\"utf-8\">\r\n"
				+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
				+ "  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\r\n"
				+ "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n"
				+ "  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\r\n"
				+ "  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\r\n"
				+ "</head>\r\n"
				+ "<div class=\"jumbotron text-center\">\r\n"
				+ "  <h1>Employee Home Page</h1>\r\n"
				+ "  		<p>Welcome</p>" + enam
				+ "<p>Your Username: </p>" + user
				+ "<p>Your Password: </p>" + epass
				+ "</div>"
				+ "<body>"
				+ "<div class=\"container\">\r\n"
				//+ "  <div class=\"row\">\r\n"
				//+ "    <div class=\"col-sm-4\">"
				+ "      <h3>Your Pending Reimbursement Requests:</h3>"
				+ "					" + requests
				//+ "		<div class=\"col-sm-4\">\""
				+ "		<h3>Your Resolved Reimbursement Requests:</h3>"
				+ "						" + res
				+ "				"
				+ "</div>"
				+ "<form action=\"newRequest.jsp\"> <input type =\"Submit\" value=\"New Reimbursement Request\"></form>"
				+ "<form action=\"index.jsp\"> <input type =\"Submit\" value=\"Logout\"></form>"
				+ "</body>"
				+ "<footer>"
				+ "<p>   </p>"
				+ "<p>   </p>"
				+ "<p>   </p>"
				+ "</footer>"
				+ "</html>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public static Pending viewEmployeeReq(String user) {
		PendingDAOImpl pDAO = new PendingDAOImpl();
		Pending check = pDAO.selectRequest(user);
		return check;
	}
	
	public static Resolved viewEmployeeRes(String user) {
		ResolvedDAOImpl pDAO = new ResolvedDAOImpl();
		Resolved check = pDAO.selectRequest(user);
		return check;
	}

}
