package com.gcu.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class User {
	@NotNull(message="First name is required")
	private String firstName;
	
	@NotNull(message="Last name is required")
	private String lastName;
	
	@NotNull(message="Email address is required")
	@Email(message="Please provide a valid email address")
	private String email;
	
	@NotNull(message="Phone number is required")
	private int phone;
	
	@NotNull(message="You must pick a user name is required")
	@Size(min=1, max=32, message="A user name must be between 1 and 32 characters")
	private String userName;
	
	@NotNull(message="A password is required")
	@Size(min=1, max=32, message="A password must be between 1 and 32 characters")
	private String password;

	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
