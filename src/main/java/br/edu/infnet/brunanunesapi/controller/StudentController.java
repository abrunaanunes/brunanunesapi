package br.edu.infnet.brunanunesapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	
	private final StudentService studentService;
	
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@PostMapping
	public ResponseEntity<Student> create(@Valid @RequestBody Student student) throws Exception {
		Student studentAdded = studentService.create(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(studentAdded);
	}
	
	@GetMapping
	public ResponseEntity<List<Student>> getAll() {
		return ResponseEntity.ok(studentService.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> getById(@PathVariable Integer id) {
		return ResponseEntity.ok(studentService.getById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Student> update(@PathVariable Integer id, @Valid @RequestBody Student student) {
		return ResponseEntity.ok(studentService.update(id, student));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		studentService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PatchMapping("/{id}/inactivate")
	public ResponseEntity<Student> inactivate(@PathVariable Integer id) {
		return ResponseEntity.ok(studentService.inactivate(id));
	}
}
