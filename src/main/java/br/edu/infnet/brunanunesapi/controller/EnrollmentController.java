package br.edu.infnet.brunanunesapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.brunanunesapi.model.domain.Enrollment;
import br.edu.infnet.brunanunesapi.model.domain.service.EnrollmentService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {
	
	private final EnrollmentService enrollmentService;
	
	public EnrollmentController(EnrollmentService enrollmentService) {
		this.enrollmentService = enrollmentService;
	}
	
	@PostMapping
	public ResponseEntity<Enrollment> create(@Valid @RequestBody Enrollment enrollment) {
		return ResponseEntity.status(HttpStatus.CREATED).body(enrollmentService.create(enrollment));
	}
	
	@GetMapping
	public ResponseEntity<List<Enrollment>> getAll() {
		return ResponseEntity.ok(enrollmentService.getAll());
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Enrollment> getById(@PathVariable Integer id) {
		return ResponseEntity.ok(enrollmentService.getById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Enrollment> update(@PathVariable Integer id, @Valid @RequestBody Enrollment enrollment) {
		return ResponseEntity.ok(enrollmentService.update(id, enrollment));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		enrollmentService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
