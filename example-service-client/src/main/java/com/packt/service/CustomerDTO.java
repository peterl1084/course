package com.packt.service;

import java.time.LocalDate;

public class CustomerDTO {
	private String firstName;
	private String lastName;

	private Integer yearOfBirth;

	private LocalDate birthDate;

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

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Integer getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(Integer yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	@Override
	public String toString() {
		return getFirstName() + " " + getLastName() + " " + getBirthDate();
	}
}
