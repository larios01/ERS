package com.larissa.ers.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.larissa.ers.employee.*;
import com.larissa.ers.manager.*;
import com.larissa.ers.pending.*;
import com.larissa.ers.resolved.*;

/**
 * Servlet implementation class ManagerLogin
 */
public class ManagerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("PostgreSQL Unable to load JDBC Driver");
		}
	}
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Manager Login
				Manager mana = new Manager();
				ManagerDAOImpl mDAO = new ManagerDAOImpl();
				String musername = request.getParameter("musername");
				String mpassword = request.getParameter("mpassword");
				mana = mDAO.selectManager(musername);
				String muser = mana.getUsername();
				String mpass = mana.getPass();
				String mnam = mana.getNam();
				
		
				HttpSession session = request.getSession();
				session.setAttribute("username", muser);
				session.setAttribute("pass", mpass);
				session.setAttribute("nam", mnam);
				
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();	
				
				List pend = viewEmpPendingRequests();
				List reso = viewEmpResolvedRequests();
				List emps = viewEmployees();
				

				
				boolean ch_u = musername.equals(muser);
				boolean ch_p = mpassword.equals(mpass);
				
				if(ch_u == true && ch_p == true) {
					
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
							+ "  <h1>Manager Home Page</h1>\r\n"
							+ "			<p>Welcome </p>" + mnam
							+ "	<p>Your Username: </p>" + muser
							+ "	<p>Your Password: </p>" + mpass
							+ "</div>"
							+ "<body>"
							+ "<div class=\"container\">\r\n"
							+ "		<h3>Current Pending Reimbursement Requests:</h3>"
							+ "						" + pend
							+ "		<h3>Current Resolved Reimbursement Requests:</h3>"
							+ "						" + reso
							+ "		<h3>Employee List:</h3>"
							+ "						" + emps
							+ "				"
							+ "</div>"
							+ "<form action=\"resolve.jsp\"> <input type =\"Submit\" value=\"Manage Pending Requests\"></form>"
							+ "<form action=\"index.jsp\"> <input type =\"Submit\" value=\"Logout\"></form>"
							+ "</body>"
							+ "<footer>"
							+ "<p>   </p>"
							+ "<p>   </p>"
							+ "<p>   </p>"
							+ "</footer>"
							+ "</html>");
					
					
					
				}
				else {
					out.println("Try again!");
				}
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public static List viewEmpPendingRequests() {
		PendingDAOImpl pDAO = new PendingDAOImpl();
		List<Pending> check = pDAO.selectAllRequests();
		return check;
	}
	
	public static List viewEmpResolvedRequests() {
		ResolvedDAOImpl rDAO = new ResolvedDAOImpl();
		List<Resolved> check = rDAO.selectAllResolved();
		return check;
	}
	
	public static List viewEmployees() {
		EmployeeDAOImplement eDAO = new EmployeeDAOImplement();
		List<Employee> check = eDAO.selectAllEmployees();
		return check;
	}

}
