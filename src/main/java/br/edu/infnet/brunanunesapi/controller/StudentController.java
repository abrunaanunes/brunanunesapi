package br.edu.infnet.brunanunesapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.brunanunesapi.model.domain.Student;
import br.edu.infnet.brunanunesapi.model.domain.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	
	private final StudentService studentService;
	
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@PostMapping
	public Student create(@RequestBody Student student) throws Exception {
		Student studentAdded = studentService.create(student);
		return studentAdded;
	}
	
	@GetMapping
	public List<Student> getAll() {
		return studentService.getAll();
	}
	
	@GetMapping("/{id}")
	public Student getById(Integer id) {
		Student student = studentService.getById(id);
		return student;
	}
	
	@PutMapping("/{id}")
	public Student update(Integer id, Student student) {
		Student studentUpdated = studentService.update(id, student);
		return studentUpdated;
	}
	
	@DeleteMapping("/{id}")
	public void delete(Integer id) {
		studentService.delete(id);
	}
	
	@PatchMapping("/{id}/inactivate")
	public Student inactivate(Integer id) {
		Student student = studentService.inactivate(id);
		return student;
	}
}
