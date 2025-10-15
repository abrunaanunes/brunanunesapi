package br.edu.infnet.brunanunesapi.model.domain;

public class Student {
	private Integer id;
	private String firstName; 
	private String lastName;
	private String birthDate;
	private String username;
	private String passowrd;
	private boolean isActive;
	
	@Override
	public String toString() {
		return String.format(
		        "Student [firstName=%s, lastName=%s, birthDate=%s, username=%s, password=%s, isActive=%b]",
		        firstName, lastName, birthDate, username, passowrd, isActive
		    );
	}
	
	public int getId() {
		return id;
	}

	public void setId(int enrollmentId) {
		this.id = enrollmentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassowrd() {
		return passowrd;
	}

	public void setPassowrd(String passowrd) {
		this.passowrd = passowrd;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}
