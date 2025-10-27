package br.edu.infnet.brunanunesapi.exceptions;

public class InvalidStudentException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidStudentException(String message) {
		super(message);
	}
}
