package br.edu.infnet.brunanunesapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.brunanunesapi.model.domain.Teacher;
import br.edu.infnet.brunanunesapi.model.domain.service.TeacherService;

@RestController
public class TeacherController {
	
	private final TeacherService teacherService;
	
	public TeacherController(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	
	@PostMapping("/api/teachers")
	public Teacher create(@RequestBody Teacher teacher) {
		Teacher teacherAdded = teacherService.create(teacher);
		return teacherAdded;
	}
	
	@GetMapping("/api/teachers")
	public List<Teacher> getAll() {
		return teacherService.getAll();
	}
}
