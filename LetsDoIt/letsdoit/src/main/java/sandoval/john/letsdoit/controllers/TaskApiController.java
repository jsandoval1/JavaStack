package sandoval.john.letsdoit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sandoval.john.letsdoit.models.Task;
import sandoval.john.letsdoit.services.TaskService;

@RestController
@RequestMapping("/api")
public class TaskApiController {

    // * Inject Task Service
    @Autowired
    private TaskService taskService;

    // * Route to get all tasks
    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    // * Route to get one task
    @GetMapping("/tasks/{id}")
    public Task getOneTask(@PathVariable Long id) {
        return taskService.getOneTask(id);
    }

    // * Route to create a task
    @PostMapping("/tasks/new")
    public Task createTask(Task task) {
        return taskService.createTask(task);
    }
}
