package br.edu.infnet.brunanunesapi.model.domain.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import br.edu.infnet.brunanunesapi.interfaces.CrudService;
import br.edu.infnet.brunanunesapi.model.domain.Student;

@Service
public class StudentService implements CrudService<Student, Integer> {

    private final Map<Integer, Student> studentMap = new ConcurrentHashMap<>();
    private final AtomicInteger nextId = new AtomicInteger(1);
    
	@Override
	public Student create(Student student) {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		studentMap.remove(id);
		
	}

}
