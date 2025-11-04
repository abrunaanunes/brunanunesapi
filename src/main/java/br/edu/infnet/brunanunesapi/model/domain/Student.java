package br.edu.infnet.brunanunesapi.model.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Student extends Person {
	

    @NotBlank(message = "Username is required.")
    @Size(max = 100, message = "Username can have at most 100 characters.")
    private String username;

    @NotBlank(message = "Password is required.")
    @Size(min = 6, max = 128, message = "Password must be between 6 and 128 characters.")
    private String passowrd;

    private boolean isActive;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    @Valid
    private Address address;

    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollments = new ArrayList<>();

    @Override
    public String toString() {
        return "[%s | Username: %s | Active: %b]"
                .formatted(super.toString(), username, isActive);
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
