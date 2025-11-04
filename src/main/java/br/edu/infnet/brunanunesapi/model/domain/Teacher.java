package br.edu.infnet.brunanunesapi.model.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Teacher extends Person {

	@Email(message = "Email must be valid.")
    @NotBlank(message = "Email is required.")
    @Size(max = 150, message = "Email can have at most 150 characters.")
    private String email;

    @NotBlank(message = "Password is required.")
    @Size(min = 3, max = 128, message = "Password must be between 3 and 128 characters.")
    private String passowrd;

    @Size(max = 100, message = "Department can have at most 100 characters.")
    private String department;

    @Size(max = 100, message = "Subject area can have at most 100 characters.")
    private String subjectArea;

    @OneToMany(mappedBy = "teacher")
    private List<Enrollment> enrollments = new ArrayList<>();

    @Override
    public String toString() {
        return "[%s | Email: %s | Department: %s | Subject Area: %s]"
                .formatted(super.toString(), email, department, subjectArea);
    }
    
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassowrd() {
		return passowrd;
	}
	public void setPassowrd(String passowrd) {
		this.passowrd = passowrd;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getSubjectArea() {
		return subjectArea;
	}
	public void setSubjectArea(String subjectArea) {
		this.subjectArea = subjectArea;
	}
}
