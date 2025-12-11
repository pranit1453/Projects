package com.demo.todoservices.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.demo.todoservices.beans.TodoTask;
import com.demo.todoservices.dto.TodoTaskDTO;

public class TodoMapper {
	public static TodoTask mapToTodoTask(TodoTaskDTO dto) {
		return new TodoTask(Integer.parseInt(dto.getTaskid()), dto.getTitle(), dto.getDescription(),
				LocalDate.parse(dto.getCreatedAt(), DateTimeFormatter.ofPattern("yyyy-MM-dd")),
				Boolean.parseBoolean(dto.getCompleted()));
	}

	public static TodoTaskDTO mapToTodoTaskDTO(TodoTask todo) {
		return new TodoTaskDTO(String.valueOf(todo.getTaskid()), todo.getTitle(), todo.getDescription(),
				String.valueOf(todo.getCreatedAt()), String.valueOf(todo.getCompleted()));
	}

}
