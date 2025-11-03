package br.edu.infnet.brunanunesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.brunanunesapi.model.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
