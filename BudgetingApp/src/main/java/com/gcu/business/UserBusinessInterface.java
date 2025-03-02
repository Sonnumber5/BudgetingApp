package com.gcu.business;

import java.util.List;

import com.gcu.model.UserModel;

public interface UserBusinessInterface {
	public UserModel findById(int id);
	public void deleteUser(UserModel user);
	public void updateUser(UserModel user);
	public List<UserModel> findAllUsers();
	public void addUser(String firstname, String lastname, String username, String password, String email);
}
