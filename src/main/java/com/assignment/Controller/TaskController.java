package com.assignment.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.Repository.TaskRepo;
import com.assignment.entity.Task;

@RestController
@RequestMapping("/task")
public class TaskController {
	static List<Task> tasklist = new ArrayList<Task>();
	static List<Task> sortedlist = new ArrayList<Task>();
 @Autowired
 private TaskRepo taskRepo;
 
 @PostMapping("/create")
 public ResponseEntity<?> createTask(@RequestBody Task task) {
	 Task task1 =taskRepo.save(task);
	 tasklist.add(task1);
	 return ResponseEntity.ok(task1);
 }
 @GetMapping("/alltasks")
 public List<Task> getAll(){
	 List<Task> task =taskRepo.findAll();
	 return task;
 }
 
 @GetMapping("/search/{title}")
 public Task titleTask(@PathVariable String title) {
	 Task task = taskRepo.getByTitle(title);
	 return task;
 }
 @GetMapping("/searchid/{taskId}")
 public Task getByID(@PathVariable Long taskId) {
	 Task task = taskRepo.findById(taskId).get();
	 return task;
 }
 @PutMapping("/update/{taskId}")
 public Task update(@PathVariable Long taskId, @RequestBody Task task) {
	 Optional<Task> optional= taskRepo.findById(taskId);
		if(optional.isPresent()) {
			Task task1=optional.get();
			task1.setTitle(task.getTitle());
			task1.setDescription(task.getDescription());
			task1.setStatus(task.getStatus());
			task1.setTime(task.getTime());
			taskRepo.save(task1);
			tasklist.add(task1);
			return task1;
		}
		return null;
 }
 @PutMapping("/assign/{taskId}")
 public Task assign(@PathVariable Long taskId, @RequestParam String assignedTo) {
	 Optional<Task> optional= taskRepo.findById(taskId);
		if(optional.isPresent()) {
			Task task1=optional.get();
			task1.setAssignedTo(assignedTo);
		taskRepo.save(task1);
		tasklist.add(task1);
		return task1;
		}
		return null;
 }
 @GetMapping("/history/{taskId}")
 public List<Task> getHistory(@PathVariable Long taskId){
	 //List<Task> list = (List<Task>) taskRepo.findById(taskId).get();
	 for(int i=0;i<tasklist.size();i++) {
		 if(tasklist.get(i).getTaskId()==taskId) {
			 Task task = tasklist.stream().filter(a -> a.getTaskId() == taskId).collect(Collectors.toList()).get(i);
			 sortedlist.add(task);
		 }
	 }
	 return sortedlist;
 }
}
