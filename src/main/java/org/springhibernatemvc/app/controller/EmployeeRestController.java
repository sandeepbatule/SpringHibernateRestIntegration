package org.springhibernatemvc.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springhibernatemvc.app.entity.Employee;
import org.springhibernatemvc.app.service.EmployeeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;
	
	//add mapping for get all employees
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return employeeService.getEmployees();
	}

	//add mapping for get a employee
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId)
	{
		Employee theEmployee=employeeService.getEmployee(employeeId);
		if(theEmployee==null) {
			throw new EmployeeNotFoundException("EmployeeId id not found-"+employeeId);
		}
		
		return theEmployee;
	}
	
	//add mapping for post /employees --- a new employee
	
		@PostMapping("/employees")
		public Employee saveEmployee(@RequestBody Employee theEmployee)
		{
			//also incase just pass an id  in json...set id it 0
			//this is a force to save new item...instead of update
			
			theEmployee.setEmpId(0);
			
			employeeService.saveEmployee(theEmployee);
			
			return theEmployee;
			
		}
				
		//add mapping for Delete /customers{employeeId}
		@DeleteMapping("/employees/{employeeId}")
		public String deleteEmployee(@PathVariable int employeeId)
		{
			Employee theEmployee=employeeService.getEmployee(employeeId);
			if(theEmployee==null)
			{
				throw new EmployeeNotFoundException("customer id not found--"+employeeId);
			}
			
			employeeService.deleteEmployee(employeeId);
			
			return "Delete employee id-"+employeeId;
		}
		
		//update record
		@PutMapping("/employees/{id}")
		public ResponseEntity<?> updateEmployee(@PathVariable("id") int id,@RequestBody Employee theEmployee){
			employeeService.updateEmployee(id, theEmployee);
			return ResponseEntity.ok().body("Employee Updated");
			
		}
	
}
