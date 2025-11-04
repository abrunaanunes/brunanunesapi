package br.edu.infnet.brunanunesapi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.brunanunesapi.model.domain.Enrollment;
import br.edu.infnet.brunanunesapi.model.domain.Student;
import br.edu.infnet.brunanunesapi.model.domain.Teacher;
import br.edu.infnet.brunanunesapi.model.domain.service.EnrollmentService;
import br.edu.infnet.brunanunesapi.model.domain.service.StudentService;
import br.edu.infnet.brunanunesapi.model.domain.service.TeacherService;

@Order(3)
@Component
public class EnrollmentLoader implements ApplicationRunner {

    private final EnrollmentService enrollmentService;
    private final StudentService studentService;
    private final TeacherService teacherService;

    public EnrollmentLoader(EnrollmentService enrollmentService, StudentService studentService, TeacherService teacherService) {
        this.enrollmentService = enrollmentService;
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        loadEnrollmentsFromCsv("enrollments.csv");
    }

    private void loadEnrollmentsFromCsv(String path) throws IOException {
        try (FileReader file = new FileReader(path);
             BufferedReader read = new BufferedReader(file)) {

            String line;

            while ((line = read.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }


                String[] data = line.split(",");

                if (data.length < 4) {
                    continue;
                }

                Enrollment enrollment = new Enrollment();
                
                Student student = studentService.getById(Integer.parseInt(data[0].trim()));
                Teacher teacher = teacherService.getById(Integer.parseInt(data[1].trim()));


                enrollment.setStudent(student);
                enrollment.setTeacher(teacher);
                enrollment.setGrade(Integer.parseInt(data[2].trim()));
                enrollment.setSubject(data[3].trim());

                enrollmentService.create(enrollment);
            }
        }
        
        System.out.println("------------ENROLLMENTS------------");
        Collection<Enrollment> enrollments = enrollmentService.getAll();
        enrollments.forEach(System.out::println);
    }
}
