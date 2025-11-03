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

import br.edu.infnet.brunanunesapi.model.domain.Teacher;
import br.edu.infnet.brunanunesapi.model.domain.service.TeacherService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {
	
	private final TeacherService teacherService;
	
	public TeacherController(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	
	@PostMapping
	public ResponseEntity<Teacher> create(@Valid @RequestBody Teacher teacher) {
		return ResponseEntity.status(HttpStatus.CREATED).body(teacherService.create(teacher));
	}
	
	@GetMapping
	public ResponseEntity<List<Teacher>> getAll() {
		return ResponseEntity.ok(teacherService.getAll());
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Teacher> getById(@PathVariable Integer id) {
		return ResponseEntity.ok(teacherService.getById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Teacher> update(@PathVariable Integer id, @Valid @RequestBody Teacher teacher) {
		return ResponseEntity.ok(teacherService.update(id, teacher));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		teacherService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
