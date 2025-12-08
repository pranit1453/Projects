package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Todos;
import com.demo.dao.TodoDao;

@Service
public class TodoServicesImpl implements TodoServices {

	@Autowired
	private TodoDao tdao;

	@Override
	public List<Todos> getList(int userid) {
		return tdao.fetchList(userid);
	}

	@Override
	public boolean addToDo(int userid, String title, String description) {
		try {
			Todos t = new Todos();
			t.setUser_id(userid);
			t.setTitle(title);
			t.setDescription(description);
			t.setCompleted(false);
			return tdao.save(t);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean toogleStatus(int id, int userid) {
		return tdao.toggleStatus(id, userid);
	}

}
