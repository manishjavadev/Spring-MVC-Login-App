package com.app.service;

import java.util.List;

import com.app.entity.UserRegistration;

public interface UserService {

	public int register(UserRegistration userregistration);
	public boolean login(String mail,String password);
	public List<UserRegistration> allUser();

}
