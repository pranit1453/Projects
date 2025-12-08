package com.demo.services;

import java.util.List;

import com.demo.beans.Todos;

public interface TodoServices {

	List<Todos> getList(int userid);

	boolean addToDo(int userid, String title, String description);

	boolean toogleStatus(int id, int userid);

}
