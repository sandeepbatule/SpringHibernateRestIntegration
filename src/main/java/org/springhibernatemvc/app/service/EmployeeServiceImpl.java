package org.springhibernatemvc.app.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springhibernatemvc.app.dao.EmployeeDAO;
import org.springhibernatemvc.app.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	// need to inject customer dao
	
	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	@Transactional
	public List<Employee> getEmployees() {
		
		return employeeDAO.getEmployees();
	}

	@Override
	@Transactional
	public void saveEmployee(Employee theEmployee) {
		
		employeeDAO.saveEmployee(theEmployee);
	}

	@Override
	@Transactional
	public void updateEmployee(int custId, Employee theEmployee) {
		
		employeeDAO.updateEmployee(custId, theEmployee);
	}

	@Override
	@Transactional
	public Employee getEmployee(int theId) {
		
		return employeeDAO.getEmployee(theId);
	}

	@Override
	@Transactional
	public void deleteEmployee(int theId) {
		
		employeeDAO.deleteEmployee(theId);
	}

}
