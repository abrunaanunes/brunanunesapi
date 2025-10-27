package br.edu.infnet.brunanunesapi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.brunanunesapi.model.domain.Teacher;
import br.edu.infnet.brunanunesapi.model.domain.service.TeacherService;

@Component
public class TeacherLoader implements ApplicationRunner {

    private final TeacherService teacherService;

    public TeacherLoader(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        loadTeachersFromCsv("teachers.csv");
    }

    private void loadTeachersFromCsv(String path) throws IOException {
        try (FileReader file = new FileReader(path);
             BufferedReader read = new BufferedReader(file)) {

            String line;

            while ((line = read.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }


                String[] data = line.split(",");

                if (data.length < 7) {
                    continue;
                }

                Teacher teacher = new Teacher();
                int idx = 0;


                teacher.setFirstName(data[idx++].trim());
                teacher.setLastName(data[idx++].trim());
                teacher.setBirthDate(data[idx++].trim());
                teacher.setEmail(data[idx++].trim());
                teacher.setPassowrd(data[idx++].trim());
                teacher.setDepartment(data[idx++].trim());
                teacher.setSubjectArea(data[idx++].trim());

                teacherService.create(teacher);
            }
        }
        
        System.out.println("------------TEACHERS------------");
        Collection<Teacher> teachers = teacherService.getAll();
        teachers.forEach(System.out::println);
    }
}
