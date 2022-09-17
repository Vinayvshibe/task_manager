//package com.assignment.service.impl;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.assignment.Repository.TaskRepo;
//import com.assignment.entity.Task;
//import com.assignment.service.TaskService;
//
//@Service
//public class TaskServiceImpl implements TaskService {
//	
//@Autowired
//private TaskRepo taskrepo;
//	
//	@Override
//	public Task createTask(Task task) {
//		taskrepo.save(task);
//		return task;
//	}
//
//	@Override
//	public Task getById(Long id) {
//		Task task= taskrepo.findById(id).get();
//		return task;
//	}
//
//	@Override
//	public List<Task> allTasks() {
//		
//		return taskrepo.findAll();
//	}
//
//	@Override
//	public Task getByTitle(String title) {
//		Task task= taskrepo.getByTitle(title);
//		return task;
//	}
//
//	@Override
//	public Task updateTask(Task task, Long id) {
//		Optional<Task> optional= taskrepo.findById(id);
//		if(optional.isEmpty()) {
//			Task task1=optional.get();
//			task1.setTitle(task.getTitle());
//			task1.setDescription(task.getDescription());
//			task1.setStatus(task.getStatus());
//			task1.setTime(task.getTime());
//			taskrepo.save(task1);
//			return task1;
//		}
//		return null;
//	}
//
//	@Override
//	public Task assignTask(String assignedTo, Long id) {
//		Optional<Task> optional= taskrepo.findById(id);
//		if(optional.isEmpty()) {
//			Task task1=optional.get();
//			task1.setAssignedTo(assignedTo);
//		taskrepo.save(task1);
//		return task1;
//		}
//		return null;
//	}
//
//	@Override
//	public List<Task> historyOfTask(Long id) {
//		
//		return null;
//	}
//
//}
