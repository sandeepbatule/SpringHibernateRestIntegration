package org.springhibernatemvc.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class EmployeeExceptionHandler {

	//add exception handle for customerNotfoundException
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException e)
	{
		//create customerErrorResponse
		EmployeeErrorResponse error=new EmployeeErrorResponse(HttpStatus.NOT_FOUND.value(),e.getMessage(),System.currentTimeMillis());
		
		//return ResponseEntity
		return new ResponseEntity<EmployeeErrorResponse>(error,HttpStatus.NOT_FOUND);
	}
	
	//add exception handler for all exception.......
	
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleException(Exception e)
	{
		//create customerErrorResponse
		EmployeeErrorResponse error=new EmployeeErrorResponse(HttpStatus.BAD_REQUEST.value(),e.getMessage(),System.currentTimeMillis());
		
		//return ResponseEntity
		return new ResponseEntity<EmployeeErrorResponse>(error,HttpStatus.BAD_REQUEST);
	}
	
}
