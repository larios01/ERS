package com.larissa.ers.manager;

import java.util.List;

public interface ManagerDAO {

	public Manager selectManager(String username);
	public Boolean insertIntoManager(Manager username);
	public List<Manager> selectAllManager();
	public Boolean updateManager(Manager username);
	
}
