package org.customer.registration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends Exception{

	private static final long serialVersionUID = -3571916857240893298L;
	
	public RecordNotFoundException(String message) {
		super(message);
	}

}
