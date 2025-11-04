package br.edu.infnet.brunanunesapi.exceptions;

public class InvalidEnrollmentException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidEnrollmentException(String message) {
		super(message);
	}
}
