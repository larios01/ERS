package com.larissa.ers.employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.larissa.ers.connection.Connecting;

public class EmployeeDAOImplement implements EmployeeDAO {

	@Override
	public Employee selectEmployee(Integer id) {
		// TODO Auto-generated method stub
		
		Employee emp = null; //// This is our model that represents the data from our database
		ResultSet rs = null; // The ResultSet is a representation of the data from our DB
		PreparedStatement ps = null;
		
		try (Connection conn = Connecting.getConnection()) {
			// SELECT * FROM examples.employees WHERE emp_id = 1000;
			ps = conn.prepareStatement("SELECT * FROM ers.employees WHERE username=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				emp = new Employee(
						rs.getString(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getInt(4),
						rs.getString(5)
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return emp;
	}

	@Override
	public Employee selectEmployee(String username) {
		// TODO Auto-generated method stub
		Employee emp = new Employee();
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "81089958");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ers.employee WHERE username =?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				emp.setUsername(rs.getString(1));
				emp.setPass(rs.getString(2));
				emp.setNam(rs.getString(3));
			}
		
		} catch (SQLException e) {
			System.out.println("Something went wrong when trying to contact DB");
			e.printStackTrace();
			return null;
		}		
		return emp;
	}

	@Override
	public Boolean insertIntoEmployees(Employee username) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		
		try (Connection conn = Connecting.getConnection()) {
			ps = conn.prepareStatement("INSERT INTO ers.employee "
					+ "VALUES(?,?,?,?,?)");
			ps.setString(1, username.getUsername());
			ps.setString(2, username.getPass());
			ps.setString(3, username.getNam());

			ps.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Employee> selectAllEmployees() {
		// TODO Auto-generated method stub
		
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Employee> employees = new ArrayList<Employee>();
		
		try (Connection conn = Connecting.getConnection()) {
			String query = "SELECT * FROM ers.employee";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setUsername(rs.getString(1));
				emp.setPass(rs.getString(2));
				emp.setNam(rs.getString(3));

				employees.add(emp);
			}

		} catch (SQLException e) {
		e.printStackTrace();
		return null;
		}

		return employees;
		}

	@Override
	public Boolean removeEmployee(Integer id) {
		// TODO Auto-generated method stub
		
		PreparedStatement ps = null;
		
		try (Connection conn = Connecting.getConnection();){
			String sql = "DELETE FROM ers.employees WHERE username=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			if (ps.executeUpdate() == 0)
				return false;
			else
				return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public Boolean updateEmployee(Employee username) {
		// TODO Auto-generated method stub
		return null;
	}


	
}

