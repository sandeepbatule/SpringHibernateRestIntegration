package org.springhibernatemvc.app.dao;

import java.util.List;

import org.springhibernatemvc.app.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> getEmployees();
	public void saveEmployee(Employee theEmployee);
	public Employee getEmployee(int theId);
	public void deleteEmployee(int theId);
	public void updateEmployee(int id,Employee theEmployee);
	
}
