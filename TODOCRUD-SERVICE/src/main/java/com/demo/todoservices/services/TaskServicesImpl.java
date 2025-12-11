package com.demo.todoservices.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.todoservices.beans.TodoTask;
import com.demo.todoservices.dao.TodoDao;
import com.demo.todoservices.dto.TodoTaskDTO;
import com.demo.todoservices.exceptions.ResourceNotFoundException;
import com.demo.todoservices.mapper.TodoMapper;

@Service
public class TaskServicesImpl implements TaskServices {
	@Autowired
	private TodoDao tdao;

	@Override
	public boolean addToDB(TodoTaskDTO dto) {
		try {
			if (dto == null) {
				throw new IllegalArgumentException("Dto is Empty");
			}
			TodoTask task = TodoMapper.mapToTodoTask(dto);
			TodoTask n = tdao.save(task);
			return (n != null) ? true : false;
		} catch (Exception e) {
			throw new RuntimeException("Task save failed", e);
		}

	}

	@Override
	public TodoTaskDTO retrieveFromDB(String taskid) {
		try {
			if (taskid == null || taskid.isBlank()) {
				throw new IllegalArgumentException("Task id cannot be null or empty");
			}
			final int id;
			try {
				id = Integer.parseInt(taskid.trim());
			} catch (NumberFormatException nfe) {
				throw new IllegalArgumentException("Task id must be a valid integer", nfe);
			}

			if (id <= 0) {
				throw new IllegalArgumentException("Task id must be a positive integer");
			}
			try {
				Optional<TodoTask> task = tdao.findById(id);
				return task.map(TodoMapper::mapToTodoTaskDTO)
						.orElseThrow(() -> new ResourceNotFoundException("Task not found for id: " + id));
			} catch (ResourceNotFoundException rnfe) {

				throw rnfe;
			}
		} catch (Exception e) {
			throw new RuntimeException("Retrievial failed!!!", e);
		}
	}

	@Override
	public TodoTaskDTO editDataInDB(String taskid) {
		// TODO Auto-generated method stub
		return null;
	}
}
