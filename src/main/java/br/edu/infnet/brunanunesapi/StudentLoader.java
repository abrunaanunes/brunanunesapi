package br.edu.infnet.brunanunesapi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collection;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.brunanunesapi.clients.ViaCepFeignClient;
import br.edu.infnet.brunanunesapi.model.domain.Student;
import br.edu.infnet.brunanunesapi.model.domain.service.StudentService;

@Order(2)
@Component
public class StudentLoader implements ApplicationRunner {

	private final StudentService studentService;
	private final ViaCepFeignClient cepFeignClient;
	
	public StudentLoader(StudentService studentService, ViaCepFeignClient cepFeignClient) {
		this.studentService = studentService;
		this.cepFeignClient = cepFeignClient;
	}

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("students.csv");
        BufferedReader read = new BufferedReader(file);

        String line = read.readLine();
        String[] studentData;

        while (line != null) {

            if (line.trim().isEmpty()) {
                line = read.readLine();
                continue;
            }

            studentData = line.split(",");

            Student student = new Student();
            student.setFirstName(studentData[0].trim());
            student.setLastName(studentData[1].trim());
            student.setBirthDate(studentData[2].trim());
            student.setUsername(studentData[3].trim());
            student.setPassowrd(studentData[4].trim());
            student.setActive(Boolean.parseBoolean(studentData[5].trim()));
            student.setAddress(cepFeignClient.findByCep(studentData[6].trim()));

            studentService.create(student);
            line = read.readLine();
        }
        
        System.out.println("------------STUDENTS------------");
        Collection<Student> students = studentService.getAll();
        students.forEach(System.out::println);
        
        read.close();
    }
}
