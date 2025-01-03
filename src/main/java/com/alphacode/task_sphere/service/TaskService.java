package com.alphacode.task_sphere.service;

import com.alphacode.task_sphere.entity.Task;
import com.alphacode.task_sphere.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id){
        return taskRepository.findById(id);
    }

    public List<Task> getTasksByProjectId(Long projectId){
        return taskRepository.getTasksByProjectId(projectId);
    }

    public Task saveTask(Task task){
        return taskRepository.save(task);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }

}
