package br.edu.infnet.brunanunesapi.model.domain;

public class Teacher extends Person {

    private String email;
    private String passowrd;
    private String department;
    private String subjectArea;
    
    public String toString() {
		return String.format(
	        "[%s | Email: %s | Password: %s | Department: %s | Subject Area: %s]",
	        super.toString(), email, passowrd, department, subjectArea
	    );
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
