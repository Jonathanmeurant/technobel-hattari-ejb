package be.technobel.domain.exceptions;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class ValidationException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

	public ValidationException(String message){
		super(message);
	}
}
