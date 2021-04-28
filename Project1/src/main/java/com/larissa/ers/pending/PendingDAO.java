package com.larissa.ers.pending;

import java.util.List;


public interface PendingDAO {

	public Pending selectRequest(Integer id);
	public Pending selectRequest(String employee);
	public Boolean insertIntoRequest(Pending employee);
	public List<Pending> selectAllRequests();
	public Boolean removeRequest(Integer id);
	public Boolean updateRequest(Pending employee);
	
}

