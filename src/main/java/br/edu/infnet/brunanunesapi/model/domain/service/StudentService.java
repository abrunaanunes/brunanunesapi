package br.edu.infnet.brunanunesapi.model.domain.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import br.edu.infnet.brunanunesapi.exceptions.InvalidStudentException;
import br.edu.infnet.brunanunesapi.exceptions.StudentNotFoundException;
import br.edu.infnet.brunanunesapi.interfaces.CrudService;
import br.edu.infnet.brunanunesapi.model.domain.Student;

@Service
public class StudentService implements CrudService<Student, Integer> {

    private final Map<Integer, Student> studentMap = new ConcurrentHashMap<>();
    private final AtomicInteger nextId = new AtomicInteger(1);
    
	@Override
	public Student create(Student student) {
		this.validateCreateOrUpdateStudent(student, "CREATE");
        student.setId(nextId.getAndIncrement());
        studentMap.put(student.getId(), student);
		return student;
	}

	@Override
	public List<Student> getAll() {
		return new ArrayList<Student>(studentMap.values());
	}

	@Override
	public Student update(Integer id, Student student) {
		Student studentUpdated = this.getById(id);
		this.validateCreateOrUpdateStudent(student, "CREATE");
		
		studentUpdated.setFirstName(student.getFirstName());
		studentUpdated.setLastName(student.getLastName());
		
		return studentUpdated;
	}

	@Override
	public void delete(Integer id) {
		Student student = this.getById(id);
		studentMap.remove(student.getId());
	}
	
	@Override
	public Student getById(Integer id) {
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("Invalid student ID");
		}
		
		Student student = studentMap.get(id);
		
		if (student == null) {
			throw new StudentNotFoundException("Student not found");
		}
		
		return student;
	}
	
	public Student inactivate(Integer id)
	{
		Student student = this.getById(id);
		
		if (student.isActive() == false) {
			System.err.println("Student is already inactive");
			return student;
		}
		
		student.setActive(false);
		
		return student;
	}
	
	private void validateCreateOrUpdateStudent(Student student, String action)
	{
		if (student == null) {
			throw new IllegalArgumentException("Student cannot be null");
		}
		
		if (student.getFirstName() == null || student.getLastName() == null) {
			throw new InvalidStudentException("Student name cannot be null");
		}
		
		if (student.getFirstName().trim().isEmpty()|| student.getLastName().trim().isEmpty()) {
			throw new InvalidStudentException("Student name cannot be empty");
		}
		
		if (action == "CREATE" && student.getId() != null && student.getId() > 0) {
			throw new IllegalArgumentException("Student must not have an ID when created");
		}
		
		if (action == "UPDATE" && student.getId() == null && student.getId() <= 0) {
			throw new IllegalArgumentException("Student must have an ID when updated");
		}
	}
}
