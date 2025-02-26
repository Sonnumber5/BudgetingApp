package com.gcu.data.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Table("USERS")
public class UserEntity {

	@Id
	private int id;
	
	@Column("FIRSTNAME")
    private String firstName;

	@Column("LASTNAME")
    private String lastName;

	@Column("USERNAME")
    private String username;

	@Column("PASSWORD")
    private String password;

	@Column("EMAIL")
    private String email;

	public UserEntity() {}
	
    public UserEntity(String firstName, String lastName, String username, String password, String email) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.username = username;
    	this.password = password;
    	this.email = email;
    }
    
    public UserEntity(int id, String firstName, String lastName, String username, String password, String email) {
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
