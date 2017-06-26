package com.app.serviceIpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.UserDao;
import com.app.entity.UserRegistration;
import com.app.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	public int register(UserRegistration userregistration)
	{
		return userDao.register(userregistration);

	}
	public boolean login(String mail,String password)
	{
		UserRegistration ur=userDao.login(mail);
		if(ur!=null && ur.getMail().equals(mail) && ur.getPassword().equals(password))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	public List<UserRegistration> allUser()
	{
		
		 List<UserRegistration> ur1=userDao.allUser();
		 return ur1;
	}
}
