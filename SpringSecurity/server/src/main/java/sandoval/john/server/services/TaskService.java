package sandoval.john.server.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import sandoval.john.server.models.Task;
import sandoval.john.server.repositories.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // *find all tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // * Find one task
    public Task getOneTask(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    // * Create a task
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    // * Update a task
    public Task updateTask(@Valid Task task) {
        return taskRepository.save(task);
    }

    // * Delete a task
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

}