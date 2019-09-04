package org.springhibernatemvc.app.service;

import java.util.List;

import org.springhibernatemvc.app.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> getEmployees();

	public void saveEmployee(Employee theEmployee);
	
	public void updateEmployee(int custId,Employee theEmployee);

	public Employee getEmployee(int theId);

	public void deleteEmployee(int theId);

}
