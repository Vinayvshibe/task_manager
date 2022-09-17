package com.assignment.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.assignment.entity.Task;


public interface TaskRepo extends MongoRepository<Task, Long> {
	//Task createTask(Task task);
	 //Task getById(Long id);
	// List<Task> allTasks();
	 Task getByTitle(String title);
	// Task updateTask (Task task, Long id);
	 //Task assignTask(String assignedTo, Long id);
	 //List<Task> historyOfTask(Long id);
}
