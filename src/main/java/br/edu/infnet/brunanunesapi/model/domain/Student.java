package br.edu.infnet.brunanunesapi.model.domain;

public class Student extends Person {
	
	private String username;
	private String passowrd;
	private boolean isActive;
	
	public String toString() {
		return String.format(
		        "[%s | Username: %s | Password: %s | Active: %b]",
		        super.toString(), username, passowrd, isActive
		    );
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
