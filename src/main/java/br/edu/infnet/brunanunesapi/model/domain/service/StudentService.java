package br.edu.infnet.brunanunesapi.model.domain.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import br.edu.infnet.brunanunesapi.exceptions.InvalidStudentException;
import br.edu.infnet.brunanunesapi.exceptions.StudentNotFoundException;
import br.edu.infnet.brunanunesapi.model.domain.Student;
import br.edu.infnet.brunanunesapi.repository.StudentRepository;

@Service
public class StudentService implements CrudService<Student, Integer> {

    private final StudentRepository studentRepository;
    
    public StudentService(StudentRepository studentRepository)
    {
    	this.studentRepository = studentRepository;
    }
    
	@Override
	public Student create(Student student) {
		this.validateCreateOrUpdateStudent(student, "CREATE");
        return studentRepository.save(student);
	}

	@Override
	public List<Student> getAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student update(Integer id, Student student) {
		student.setId(id);
		this.validateCreateOrUpdateStudent(student, "UPDATE");
		
		return studentRepository.save(student);
	}

	@Override
	public void delete(Integer id) {
		Student student = this.getById(id);
		studentRepository.delete(student);
	}
	
	@Override
	public Student getById(Integer id) {
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("Invalid student ID");
		}
		
		return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found"));
	}
	
	public Student inactivate(Integer id)
	{
		Student student = this.getById(id);
		
		if (student.isActive() == false) {
			System.err.println("Student is already inactive");
			return student;
		}
		
		student.setActive(false);
		
		return studentRepository.save(student);
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
