package com.demo.dao;

import java.util.List;

import com.demo.beans.Todos;

public interface TodoDao {

	List<Todos> fetchList(int userid);

	boolean save(Todos t);

	boolean toggleStatus(int id, int userid);

}
