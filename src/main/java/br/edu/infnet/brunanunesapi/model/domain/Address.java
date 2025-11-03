package br.edu.infnet.brunanunesapi.model.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonProperty("cep")
	@NotNull(message = "CEP is required.")
	private String zipCode;
	
	@JsonProperty("localidade")
	private String city;
	
	@JsonProperty("uf")
	private String state;
	
	@Override
	public String toString() {
		return "Address [id=" + id + ", zipCode=" + zipCode + ", city=" + city + ", state=" + state + "]";
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
