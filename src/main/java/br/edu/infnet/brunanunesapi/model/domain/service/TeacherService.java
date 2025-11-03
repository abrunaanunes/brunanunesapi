package br.edu.infnet.brunanunesapi.model.domain.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import br.edu.infnet.brunanunesapi.exceptions.InvalidTeacherException;
import br.edu.infnet.brunanunesapi.exceptions.TeacherNotFoundException;
import br.edu.infnet.brunanunesapi.model.domain.Teacher;
import br.edu.infnet.brunanunesapi.repository.TeacherRepository;

@Service
public class TeacherService implements CrudService<Teacher, Integer> {

    private final TeacherRepository teacherRepository;
    
    public TeacherService(TeacherRepository teacherRepository)
    {
    	this.teacherRepository = teacherRepository;
    }
    
	@Override
	public Teacher create(Teacher teacher) {
		this.validateCreateOrUpdateTeacher(teacher, "CREATE");
		return teacherRepository.save(teacher);
	}

	@Override
	public List<Teacher> getAll() {
		return teacherRepository.findAll();
	}

	@Override
	public Teacher update(Integer id, Teacher teacher) {
		this.validateCreateOrUpdateTeacher(teacher, "UPDATE");
		teacher.setId(id);
		
		return teacherRepository.save(teacher);
	}

	@Override
	public void delete(Integer id) {
		Teacher teacher = this.getById(id);
		teacherRepository.delete(teacher);
	}

	@Override
	public Teacher getById(Integer id) {
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("Invalid teacher ID");
		}
		
		return teacherRepository.findById(id).orElseThrow(() -> new TeacherNotFoundException("Teacher not found"));
	}
	
	private void validateCreateOrUpdateTeacher(Teacher teacher, String action)
	{
		if (teacher == null) {
			throw new IllegalArgumentException("Teacher cannot be null");
		}
		
		if (teacher.getFirstName() == null || teacher.getLastName() == null) {
			throw new InvalidTeacherException("Teacher name cannot be null");
		}
		
		if (teacher.getFirstName().trim().isEmpty()|| teacher.getLastName().trim().isEmpty()) {
			throw new InvalidTeacherException("Teacher name cannot be empty");
		}
		
		if (action == "CREATE" && teacher.getId() != null && teacher.getId() > 0) {
			throw new IllegalArgumentException("Teacher must not have an ID when created");
		}
		
		if (action == "UPDATE" && teacher.getId() == null && teacher.getId() <= 0) {
			throw new IllegalArgumentException("Teacher must have an ID when updated");
		}
	}
}
