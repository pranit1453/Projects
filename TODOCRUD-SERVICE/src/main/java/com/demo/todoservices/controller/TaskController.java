package com.demo.todoservices.controller;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.todoservices.dto.TodoTaskDTO;
import com.demo.todoservices.response.ApiResponse;
import com.demo.todoservices.services.TaskServices;

@RestController
@RequestMapping("/task")
public class TaskController {
	@Autowired
	private TaskServices taskservices;

	@PostMapping("/add")
	public ResponseEntity<ApiResponse<TodoTaskDTO>> getInDB(@RequestBody TodoTaskDTO dto) {
		if (dto == null) {
			return ResponseEntity.badRequest().body(new ApiResponse<>(false, "DTO is empty", null));
		}
		try {
			boolean saved = taskservices.addToDB(dto);
			if (saved) {
				return ResponseEntity.status(HttpStatus.SC_CREATED).body(new ApiResponse<>(true, "Task Added", dto));
			} else {
				return ResponseEntity.badRequest().body(new ApiResponse<>(false, "Unable to create task", null));
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.SC_SERVER_ERROR)
					.body(new ApiResponse<>(false, "Internal Server Error", null));
		}
	}

	@GetMapping("/data/{taskid}")
	public ResponseEntity<ApiResponse<TodoTaskDTO>> getById(@PathVariable("taskid") String taskid) {
		if (taskid == null) {
			return ResponseEntity.badRequest().body(new ApiResponse<>(false, "id cannot be null", null));
		}
		try {
			TodoTaskDTO retrieved = taskservices.retrieveFromDB(taskid);

			return (retrieved != null)
					? ResponseEntity.status(HttpStatus.SC_CREATED)
							.body(new ApiResponse<>(true, "Data retrieved", retrieved))
					: ResponseEntity.badRequest().body(new ApiResponse<>(false, "Unable to retrieve data", null));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.SC_SERVER_ERROR)
					.body(new ApiResponse<>(false, "Internal Server Error", null));
		}
	}

	@DeleteMapping("/edit/{taskid}")
	public ResponseEntity<ApiResponse<TodoTaskDTO>> editById(@PathVariable("taskid") String taskid) {
		if (taskid == null) {
			return ResponseEntity.badRequest().body(new ApiResponse<>(false, "id cannot be null", null));
		}
		try {
			TodoTaskDTO updated = taskservices.editDataInDB(taskid);
			return (updated != null)
					? ResponseEntity.status(HttpStatus.SC_CREATED)
							.body(new ApiResponse<>(true, "Data Updated Successfully...", updated))
					: ResponseEntity.badRequest().body(new ApiResponse<>(false, "unable to update the data!!!", null));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.SC_INTERNAL_SERVER_ERROR)
					.body(new ApiResponse<>(false, "Internal Server error", null));
		}

	}
}
