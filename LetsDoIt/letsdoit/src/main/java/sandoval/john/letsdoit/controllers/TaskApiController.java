package sandoval.john.letsdoit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import sandoval.john.letsdoit.models.Task;
import sandoval.john.letsdoit.services.TaskService;

@RestController("/api")
public class TaskApiController {

    // * Inject Task Service
    @Autowired
    private TaskService taskService;

    // * Route to get all tasks
    @GetMapping("/tasks")
    public List<Task> index() {
        return taskService.allTasks();
    }

    
}
