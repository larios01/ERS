package com.larissa.ers.pending;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.larissa.ers.connection.Connecting;


public class PendingDAOImpl implements PendingDAO {

	@Override
	public Pending selectRequest(Integer id) {
		// TODO Auto-generated method stub
		Pending req = null; //// This is our model that represents the data from our database
		ResultSet rs = null; // The ResultSet is a representation of the data from our DB
		PreparedStatement ps = null;
		
		try (Connection conn = Connecting.getConnection()) {
			// SELECT * FROM examples.employees WHERE emp_id = 1000;
			ps = conn.prepareStatement("SELECT * FROM ers.pending WHERE reqId=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				req = new Pending(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getInt(3)
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return req;
	}

	@Override
	public Pending selectRequest(String employee) {
		// TODO Auto-generated method stub
		Pending req = new Pending();
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "81089958");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ers.pending WHERE employee =?");
			ps.setString(1, employee);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				req.setReqId(rs.getInt(1));
				req.setEmployee(rs.getString(2));
				req.setAmount(rs.getInt(3));
			}
		
		} catch (SQLException e) {
			System.out.println("Something went wrong when trying to contact DB");
			e.printStackTrace();
			return null;
		}		
		return req;
	}

	@Override
	public Boolean insertIntoRequest(Pending employee) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		
		try (Connection conn = Connecting.getConnection()) {
			ps = conn.prepareStatement("INSERT INTO ers.pending "
					+ "VALUES(?,?,?)");
			ps.setInt(1, employee.getReqId());
			ps.setString(2, employee.getEmployee());
			ps.setInt(3, employee.getAmount());

			ps.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<Pending> selectAllRequests() {
		// TODO Auto-generated method stub
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Pending> requests = new ArrayList<Pending>();
		
		try (Connection conn = Connecting.getConnection()) {
			String query = "SELECT * FROM ers.pending";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				Pending req = new Pending();
				req.setReqId(rs.getInt(1));
				req.setEmployee(rs.getString(2));
				req.setAmount(rs.getInt(3));

				requests.add(req);
			}

		} catch (SQLException e) {
		e.printStackTrace();
		return null;
		}

		return requests;
	}

	@Override
	public Boolean removeRequest(Integer id) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		
		try (Connection conn = Connecting.getConnection();){
			String sql = "DELETE FROM ers.pending WHERE reqId=?";
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
	public Boolean updateRequest(Pending employee) {
		// TODO Auto-generated method stub
		return null;
	}

}
