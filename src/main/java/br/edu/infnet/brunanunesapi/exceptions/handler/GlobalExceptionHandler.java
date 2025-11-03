package br.edu.infnet.brunanunesapi.exceptions.handler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.edu.infnet.brunanunesapi.exceptions.InvalidStudentException;
import br.edu.infnet.brunanunesapi.exceptions.InvalidTeacherException;
import br.edu.infnet.brunanunesapi.exceptions.StudentNotFoundException;
import br.edu.infnet.brunanunesapi.exceptions.TeacherNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		Map<String, String> map = new HashMap<String, String>();
		
		e.getBindingResult().getAllErrors().forEach((err) -> {
			String label = ((FieldError) err).getField();
			String message = err.getDefaultMessage();
			map.put(label, message);
		});
		
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidStudentException.class)
	public ResponseEntity<Map<String, String>> handleInvalidStudentException(InvalidStudentException e) {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("timestamp", LocalDateTime.now().toString());
		map.put("status", HttpStatus.BAD_REQUEST.toString());
		map.put("error", e.getMessage());
		map.put("detail", "Invalid student data.");
		
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleStudentNotFoundException(StudentNotFoundException e) {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("timestamp", LocalDateTime.now().toString());
		map.put("status", HttpStatus.NOT_FOUND.toString());
		map.put("error", e.getMessage());
		map.put("detail", "Student not found.");
		
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidTeacherException.class)
	public ResponseEntity<Map<String, String>> handleInvalidTeacherException(InvalidTeacherException e) {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("timestamp", LocalDateTime.now().toString());
		map.put("status", HttpStatus.BAD_REQUEST.toString());
		map.put("error", e.getMessage());
		map.put("detail", "Invalid teacher data.");
		
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(TeacherNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleTeacherNotFoundException(TeacherNotFoundException e) {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("timestamp", LocalDateTime.now().toString());
		map.put("status", HttpStatus.NOT_FOUND.toString());
		map.put("error", e.getMessage());
		map.put("detail", "Teacher not found.");
		
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Map<String, String>> handleIllegalArgumentException(IllegalArgumentException e) {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("timestamp", LocalDateTime.now().toString());
		map.put("status", HttpStatus.BAD_REQUEST.toString());
		map.put("error", e.getMessage());
		map.put("detail", "Illegal argument exception.");
		
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Map<String, String>> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("timestamp", LocalDateTime.now().toString());
		map.put("status", HttpStatus.CONFLICT.toString());
		map.put("error", e.getMessage());
		map.put("detail", "Data integrity violation exception.");
		
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Map<String, String>> handleRuntimeException(RuntimeException e) {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("timestamp", LocalDateTime.now().toString());
		map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.toString());
		map.put("error", e.getMessage());
		map.put("detail", "RuntimeException.");
		
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
