package com.demo.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.beans.Todos;

@Repository
public class TodoDaoImpl implements TodoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Todos> fetchList(int userid) {

		String sql = "SELECT id, title, description, is_completed, user_id FROM todos WHERE user_id = ? ORDER BY id";

//		List<Todos> todolist = jdbcTemplate.query(sql, (rs, n) -> {
//			Todos todo = new Todos();
//			todo.setId(rs.getInt("id"));
//			todo.setTitle(rs.getString("title"));
//			todo.setDesciption(rs.getString("description"));
//			todo.setIs_completed(rs.getBoolean("is_completed"));
//			todo.setUser_id(rs.getInt("user_id"));
//			return todo;
//		}, userid); // This passes the value of userid to replace the ? in your SQL query.

		List<Todos> todolist = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Todos.class), userid);
		// it return empty list not a null value.
		return todolist == null ? Collections.emptyList() : todolist;

	}

	@Override
	public boolean save(Todos t) {
		String sql = "INSERT INTO todos (user_id,title, description, is_completed, created_at) VALUES (?, ?, ?, ?,Now())";
		int n = jdbcTemplate.update(sql,
				new Object[] { t.getUser_id(), t.getTitle(), t.getDescription(), t.getCompleted() ? 1 : 0 });
		return n > 0;
	}

	@Override
	public boolean toggleStatus(int id, int userid) {
		String sql = "Update todos SET is_completed=NOT is_completed where id=? and user_id=?";
		int n = jdbcTemplate.update(sql, new Object[] { id, userid });
		return n > 0;
	}

}
