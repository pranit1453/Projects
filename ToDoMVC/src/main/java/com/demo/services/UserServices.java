package com.demo.services;

import com.demo.beans.Users;

public interface UserServices {

	Users validateUser(String username, String password);

}
