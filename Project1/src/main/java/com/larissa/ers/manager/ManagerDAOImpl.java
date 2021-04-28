package com.larissa.ers.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.larissa.ers.connection.Connecting;
import com.larissa.ers.employee.Employee;
import com.larissa.ers.pending.Pending;

public class ManagerDAOImpl implements ManagerDAO {

	@Override
	public Manager selectManager(String username) {
		// TODO Auto-generated method stub
		Manager man = new Manager();
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "81089958");
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ers.manager WHERE username =?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				man.setUsername(rs.getString(1));
				man.setPass(rs.getString(2));
				man.setNam(rs.getString(3));

			}
		
		} catch (SQLException e) {
			System.out.println("Something went wrong when trying to contact DB");
			e.printStackTrace();
			return null;
		}		
		return man;
	}

	@Override
	public Boolean insertIntoManager(Manager username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Manager> selectAllManager() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Boolean updateManager(Manager username) {
		// TODO Auto-generated method stub
		return null;
	}

}
