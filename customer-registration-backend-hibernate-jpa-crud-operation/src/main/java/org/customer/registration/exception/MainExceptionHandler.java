package org.customer.registration.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class MainExceptionHandler {
	
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> recordNotFoundException(RecordNotFoundException rnfe, 
													 WebRequest webRequest){
		ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(), 
													 rnfe.getMessage(), 
													 webRequest.getDescription(false));
		
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> mainExceptionHandler(Exception rnfe, 
												  WebRequest webRequest){
		ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(), 
													 rnfe.getMessage(), 
													 webRequest.getDescription(false));
		
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
