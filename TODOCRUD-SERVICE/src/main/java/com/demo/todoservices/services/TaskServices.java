package com.demo.todoservices.services;

import com.demo.todoservices.dto.TodoTaskDTO;

public interface TaskServices {

	boolean addToDB(TodoTaskDTO dto);

	TodoTaskDTO retrieveFromDB(String taskid);

	TodoTaskDTO editDataInDB(String taskid);

}
