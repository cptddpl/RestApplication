package com.webservices.restservice.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.webservices.restservice.user.UserNotFoundException;

@ControllerAdvice
@RestController
public class CustomREEH  extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex,WebRequest request)
	{
		StdException stdexp = new StdException(new Date(),ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity(stdexp,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex,WebRequest request)
	{
		StdException stdexp = new StdException(new Date(),ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity(stdexp,HttpStatus.NOT_FOUND); 
	}
	

}
