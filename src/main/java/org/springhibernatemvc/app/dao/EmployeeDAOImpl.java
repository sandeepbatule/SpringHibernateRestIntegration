package org.springhibernatemvc.app.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springhibernatemvc.app.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Employee> getEmployees() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Employee> theQuery =currentSession.createQuery("from Employee order by last_name",Employee.class);
		
		// execute query and get result list
		List<Employee> employees = theQuery.getResultList();
				System.out.println(employees.get(0));
		// return the results		
		return employees;
	}

	@Override
	public void saveEmployee(Employee theEmployee) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the employee 
		currentSession.saveOrUpdate(theEmployee);
	}

	@Override
	public Employee getEmployee(int theId) {
	
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Employee theEmployee = currentSession.get(Employee.class, theId);
		
		return theEmployee;
	}

	@Override
	public void deleteEmployee(int theId) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		
		theQuery.executeUpdate();	
	}

	@Override
	public void updateEmployee(int id, Employee theEmployee) {
		// TODO Auto-generated method stub
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Employee employee=currentSession.byId(Employee.class).load(id);
		
		employee.setFirstName(theEmployee.getFirstName());
		employee.setLastName(theEmployee.getLastName());
		employee.setAddress(theEmployee.getAddress());
		employee.setDob(theEmployee.getDob());
		employee.setMobile(theEmployee.getMobile());
		employee.setCity(theEmployee.getCity());
		currentSession.flush();
	}

}
