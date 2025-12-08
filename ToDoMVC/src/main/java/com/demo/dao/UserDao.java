package com.demo.dao;

import com.demo.beans.Users;

public interface UserDao {

	Users authenticateUser(String username, String password);

}
