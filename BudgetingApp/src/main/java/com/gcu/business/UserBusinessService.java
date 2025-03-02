package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gcu.data.UserDataService;
import com.gcu.data.entities.UserEntity;
import com.gcu.model.UserModel;


@Service
public class UserBusinessService implements UserDetailsService, UserBusinessInterface
{
	@Autowired
	UserDataService userDataService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		// Try to find the User in the database. If not found throw a User Not found exception else return a Spring Security User.
		UserEntity user = userDataService.findByUsername(username);
		if(user != null)
		{
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("USER"));
			return new User(Integer.toString(user.getId()), user.getPassword(), authorities);
		}
		else
		{
			throw new UsernameNotFoundException("username not found");
		}
	}
	
	@Override
	public void addUser(String firstname, String lastname, String username, String password, String email) {
		UserEntity user = new UserEntity(firstname, lastname, username, password, email);
		try {
			userDataService.create(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public List<UserModel> findAllUsers() {
		List<UserEntity> userEntities = userDataService.findAll();
		List<UserModel> users = new ArrayList<>();
		
		for (UserEntity entity : userEntities) {
			users.add(new UserModel(entity.getId(), entity.getFirstName(), entity.getLastName(), entity.getUsername(), entity.getPassword(), entity.getEmail()));
		}
		return users;
	}

	@Override
	public UserModel findById(int id) {
		UserEntity userEntity = userDataService.findById(id);
		return new UserModel(userEntity.getId(), userEntity.getFirstName(), userEntity.getLastName(), userEntity.getUsername(), userEntity.getPassword(), userEntity.getEmail());
	}
	
	@Override
	public void updateUser(UserModel user) {
		UserEntity userEntity = userDataService.findById(user.getId());
		
		userEntity.setFirstName(user.getFirstName());
		userEntity.setLastName(user.getLastName());
		userEntity.setUsername(user.getUsername());
		userEntity.setPassword(user.getPassword());
		userEntity.setEmail(user.getEmail());
		
		userDataService.update(userEntity);
	}

	@Override
	public void deleteUser(UserModel user) {
		userDataService.delete(user.getId());
	}
}
