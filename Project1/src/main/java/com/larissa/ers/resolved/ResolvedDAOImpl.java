package com.larissa.ers.resolved;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.larissa.ers.connection.Connecting;
import com.larissa.ers.pending.Pending;

public class ResolvedDAOImpl implements ResolvedDAO {

	@Override
	public Resolved selectRequest(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resolved selectRequest(String employee) {
		// TODO Auto-generated method stub
		Resolved req = new Resolved();
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "81089958");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ers.resolved WHERE employee =?");
			ps.setString(1, employee);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				req.setStatus(rs.getString(1));
				req.setEmployee(rs.getString(2));
				req.setAmount(rs.getInt(3));
				req.setReqId(rs.getInt(4));
			}
		
		} catch (SQLException e) {
			System.out.println("Something went wrong when trying to contact DB");
			e.printStackTrace();
			return null;
		}		
		return req;
	}

	@Override
	public Boolean insertIntoRequest(Resolved employee) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				PreparedStatement ps = null;
				
				try (Connection conn = Connecting.getConnection()) {
					ps = conn.prepareStatement("INSERT INTO ers.resolved "
							+ "VALUES(?,?,?,?)");
					ps.setString(1, employee.getStatus());
					ps.setString(2, employee.getEmployee());
					ps.setInt(3, employee.getAmount());
					ps.setInt(4, employee.getReqId());

					ps.executeUpdate();
				
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
				return true;
	}

	@Override
	public List<Resolved> selectAllResolved() {
		// TODO Auto-generated method stub
		Statement stmt = null;
		ResultSet rs = null;
		List<Resolved> requests = new ArrayList<Resolved>();
		
		try (Connection conn = Connecting.getConnection()) {
			String query = "SELECT * FROM ers.resolved";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				Resolved req = new Resolved();
				req.setStatus(rs.getString(1));
				req.setEmployee(rs.getString(2));
				req.setAmount(rs.getInt(3));
				req.setReqId(rs.getInt(4));

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
		return null;
	}

	@Override
	public Boolean updateRequest(Resolved employee) {
		// TODO Auto-generated method stub
		return null;
	}

}
