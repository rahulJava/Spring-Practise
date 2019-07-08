package com.luv2code.springboot.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	private static int usersCount=3;
	static
	{
		users.add(new User(1,"Adam",new Date()));
		users.add(new User(2,"Eve",new Date()));
		users.add(new User(3,"Rahul",new Date()));
	}
	public List<User> findAll()
	{
		return users;
	}
	public User save(User user)
	{
		if(user.getID()==null)
		{
			user.setID(++usersCount);
		}
		users.add(user);
		return user;
	}
	public User findOne(int id)
	{
		for(User user:users)
		{
			if(user.getID()==id)
			{
				return user;
			}
			
		}
		return null;
	}
	public User deleteByID(int id)
	{
		Iterator<User> iterator=users.iterator();
		while(iterator.hasNext())
		{
			User user = iterator.next();
			if(user.getID()==id)
			{
				iterator.remove(); 
				return user;
			}
			
		}
		return null;
	}
	
	

}
