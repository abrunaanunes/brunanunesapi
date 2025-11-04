package br.edu.infnet.brunanunesapi.model.domain.service;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.infnet.brunanunesapi.exceptions.EnrollmentNotFoundException;
import br.edu.infnet.brunanunesapi.model.domain.Enrollment;
import br.edu.infnet.brunanunesapi.repository.EnrollmentRepository;

@Service
public class EnrollmentService implements CrudService<Enrollment, Integer> {

    private final EnrollmentRepository enrollmentRepository;
    
    public EnrollmentService(EnrollmentRepository enrollmentRepository)
    {
    	this.enrollmentRepository = enrollmentRepository;
    }
    
	@Override
	public Enrollment create(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
	}

	@Override
	public List<Enrollment> getAll() {
		return enrollmentRepository.findAll();
	}

	@Override
	public Enrollment update(Integer id, Enrollment enrollment) {
		enrollment.setId(id);
		return enrollmentRepository.save(enrollment);
	}

	@Override
	public void delete(Integer id) {
		Enrollment enrollment = this.getById(id);
		enrollmentRepository.delete(enrollment);
	}
	
	@Override
	public Enrollment getById(Integer id) {
		if (id == null || id <= 0) {
			throw new IllegalArgumentException("Invalid student ID");
		}
		
		return enrollmentRepository.findById(id).orElseThrow(() -> new EnrollmentNotFoundException("Enrollment not found"));
	}
}
