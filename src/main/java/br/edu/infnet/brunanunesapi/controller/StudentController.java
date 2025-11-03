package br.edu.infnet.brunanunesapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public Student getById(@PathVariable Integer id) {
		return studentService.getById(id);
	}
	
	@PutMapping("/{id}")
	public Student update(@PathVariable Integer id, @RequestBody Student student) {
		return studentService.update(id, student);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		studentService.delete(id);
	}
	
	@PatchMapping("/{id}/inactivate")
	public Student inactivate(@PathVariable Integer id) {
		return studentService.inactivate(id);
	}
}
