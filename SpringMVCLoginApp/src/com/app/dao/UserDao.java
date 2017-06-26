package com.app.dao;

import java.util.List;

import com.app.entity.UserRegistration;

public interface UserDao {

	
	public int register(UserRegistration userregistration);
	public UserRegistration login(String mail);
	public List<UserRegistration> allUser();
}
