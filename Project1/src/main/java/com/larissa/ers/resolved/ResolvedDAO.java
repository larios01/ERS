package com.larissa.ers.resolved;

import java.util.List;


public interface ResolvedDAO {

	public Resolved selectRequest(Integer id);
	public Resolved selectRequest(String employee);
	public Boolean insertIntoRequest(Resolved employee);
	public List<Resolved> selectAllResolved();
	public Boolean removeRequest(Integer id);
	public Boolean updateRequest(Resolved employee);
	
}
