package br.edu.infnet.brunanunesapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.brunanunesapi.model.domain.Student;
import br.edu.infnet.brunanunesapi.model.domain.service.StudentService;

@RestController
public class StudentController {
	
	private final StudentService studentService;
	
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@PostMapping("/api/students")
	public Student create(@RequestBody Student student) {
		Student studentAdded = studentService.create(student);
		return studentAdded;
	}
	
	@GetMapping("/api/students")
	public List<Student> getAll() {
		return studentService.getAll();
	}
}
