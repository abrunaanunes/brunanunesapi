package br.edu.infnet.brunanunesapi.model.domain;

public abstract class Person {
	
	private Integer id;
	private String firstName; 
	private String lastName;
	private String birthDate;
	
	@Override
	public String toString() {
		return String.format(
		        "first Name: %s | Last Name: %s | Birth Date: %s",
		        firstName, lastName, birthDate
		    );
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer enrollmentId) {
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
}
