package com.larissa.ers.employee;

import java.util.List;


public interface EmployeeDAO {
	public Employee selectEmployee(Integer id);
	public Employee selectEmployee(String username);
	public Boolean insertIntoEmployees(Employee username);
	public List<Employee> selectAllEmployees();
	public Boolean removeEmployee(Integer id);
	public Boolean updateEmployee(Employee username);
}
