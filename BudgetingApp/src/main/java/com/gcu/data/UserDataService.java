package com.gcu.data;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.data.entities.UserEntity;
import com.gcu.data.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

@Service
public class UserDataService implements DataAccessInterface<UserEntity>,UsersDataAccessInterface<UserEntity> {
    @Autowired
    private UserRepository userRepository;
    @SuppressWarnings("unused")
    private DataSource source;
    private JdbcTemplate jdbcTemplate;

    public UserDataService(UserRepository userRepository, DataSource dataSource) {
        this.userRepository = userRepository;
        this.source = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<UserEntity> findAll() {
        List<UserEntity> users = new ArrayList<>();
        try{
            users.addAll(userRepository.findAll());
        } catch(Exception e){
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public UserEntity findById(int id) {
        List<UserEntity> users = userRepository.findAll();
        for(UserEntity user : users){
            if(id == user.getId()){
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean create(UserEntity user) {
    	// Create the SQL query template
        String sql = "INSERT INTO USERS(FIRSTNAME, LASTNAME, USERNAME, PASSWORD, EMAIL) VALUES (?,?,?,?,?)";
        try{
        	// Fill out the template with the updated information
        	jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getUsername(), user.getPassword(), user.getEmail());
        } catch(Exception e){
        	// Print an error if one occurs
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(UserEntity user) {
    	String sql = "UPDATE USERS SET FIRSTNAME=?, LASTNAME=?, USERNAME=?, PASSWORD=?, EMAIL=? WHERE ID=?";
        try {
            jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getUsername(), user.getPassword(), user.getEmail(), user.getId());
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        try {
            jdbcTemplate.update("DELETE FROM USERS WHERE ID = ?", id);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }


	@Override
	public UserEntity findByUsername(String username)
	{
		return userRepository.findByUsername(username);
	}
}
