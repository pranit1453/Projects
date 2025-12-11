package com.demo.todoservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.todoservices.beans.TodoTask;

@Repository
public interface TodoDao extends JpaRepository<TodoTask, Integer> {

}
