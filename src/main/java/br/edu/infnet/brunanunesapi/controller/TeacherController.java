package br.edu.infnet.brunanunesapi.controller;

import java.util.List;

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

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {
	
	private final TeacherService teacherService;
	
	public TeacherController(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	
	@PostMapping
	public Teacher create(@RequestBody Teacher teacher) {
		return teacherService.create(teacher);
	}
	
	@GetMapping
	public List<Teacher> getAll() {
		return teacherService.getAll();
	}
	
	
	@GetMapping("/{id}")
	public Teacher getById(@PathVariable Integer id) {
		return teacherService.getById(id);
	}
	
	@PutMapping("/{id}")
	public Teacher update(@PathVariable Integer id, @RequestBody Teacher teacher) {
		return teacherService.update(id, teacher);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		teacherService.delete(id);
	}
}
