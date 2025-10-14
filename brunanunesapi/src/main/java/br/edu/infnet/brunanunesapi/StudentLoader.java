package br.edu.infnet.brunanunesapi;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.model.domain.Student;

@Component
public class StudentLoader implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		FileReader file = new FileReader("students.csv");		
		BufferedReader read = new BufferedReader(file);
		
		String line = read.readLine();
		String[] studentData = null;
		
		while (line != null) {
			studentData = line.split(",");
			
			Student student = new Student();
			student.setFirstName(studentData[0]);
			student.setLastName(studentData[1]);
			// student.setBirthDate(studentData[2]);
			student.setUsername(studentData[3]);
			student.setPassowrd(studentData[4]);
			student.setActive(Boolean.valueOf(studentData[5]));
			
			System.out.println(student.toString());
			
			line = read.readLine();
		}
		
		read.close();
		System.out.println("Carregamento automático dos alunos...");
	}
	
}
