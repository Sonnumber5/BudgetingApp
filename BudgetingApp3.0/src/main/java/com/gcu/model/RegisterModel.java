package com.gcu.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RegisterModel {

	//RegisterModel which contains 5 required properties: First name, last name, username, password, and email
	
    @NotNull(message = "First name is a required field")
    @Size(min = 1, max = 32, message = "First name must be between 1 and 32 characters")
    private String firstName;

    @NotNull(message = "Last name is a required field")
    @Size(min = 1, max = 32, message = "Last name must be between 1 and 32 characters")
    private String lastName;

    @NotNull(message = "Username is a required field")
    @Size(min = 1, max = 32, message = "Username must be between 1 and 32 characters")
    private String username;

    @NotNull(message = "Password is a required field")
    @Size(min = 1, max = 32, message = "Password must be between 1 and 32 characters")
    private String password;

    @NotNull(message = "Email is a required field")
    @Email(message = "Please provide a valid email address")
    private String email;

    
    //Getters and setters 
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
