package com.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Users;
import com.demo.dao.UserDao;

@Service
public class UserServicesImpl implements UserServices {

	@Autowired
	private UserDao udao;

	@Override
	public Users validateUser(String username, String password) {
		return udao.authenticateUser(username, password);
	}
}
