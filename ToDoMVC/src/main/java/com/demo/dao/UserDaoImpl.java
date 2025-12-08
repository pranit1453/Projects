package com.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.beans.Users;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Users authenticateUser(String username, String password) {
		try {
			Users user = jdbcTemplate.queryForObject(
					"SELECT userid, username, password, contact, gender, role FROM users WHERE username = ? AND password = ?",
					new BeanPropertyRowMapper<>(Users.class), username, password);

			if (user != null) {
				return user;
			}
		} catch (EmptyResultDataAccessException e) {
			System.out.println(e.getMessage());
		}

		return null;
	}
}
