package br.edu.infnet.brunanunesapi.exceptions;

public class InvalidTeacherException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidTeacherException(String message) {
		super(message); 
	} 
}
