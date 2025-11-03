package br.edu.infnet.brunanunesapi.model.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
