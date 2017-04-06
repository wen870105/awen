package com.wen.service;

import org.springframework.stereotype.Service;

import com.wen.export.User;
import com.wen.export.User2;
import com.wen.export.UserService;

/**
 * 
 * @author Wen
 *
 * @CreateDate 2017年3月6日
 */
@Service(value="userServiceImpl")
public class UserServiceImpl implements UserService{

	@Override
	public User test(User query) {
		System.out.println(query);
		User s = new User();
		s.setName("hhhhhh");
		return s;
	}

	@Override
	public User test123(User query, String a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User test456(User query, int a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User test4567(User2 query, int a) {
		// TODO Auto-generated method stub
		return null;
	}

}
