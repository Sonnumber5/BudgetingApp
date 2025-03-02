package com.gcu.model;

public class UserModel {

	private int id;
	
    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private String email;

    public UserModel() {}
    
    public UserModel(String firstName, String lastName, String username, String password, String email) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.username = username;
    	this.password = password;
    	this.email = email;
    }
    
    public UserModel(int id, String firstName, String lastName, String username, String password, String email) {
    	this.id = id;
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.username = username;
    	this.password = password;
    	this.email = email;
    }
    
    
    //Getters and setters 
    public int getId() {
    	return id;
    }
    
    public void setId(int id) {
    	this.id = id;
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

    public void setLastName(String lastname) {
        this.lastName = lastname;
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
