package sandoval.john.server.controllers;

// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import sandoval.john.server.services.TaskService;
// import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.*; //! Try this after
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import sandoval.john.server.models.Task;
// import sandoval.john.server.models.User;
// import sandoval.john.server.models.Comment;

@RestController
// @CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class TaskApiController {

    @Autowired
    private TaskService taskService;

    // * Route to get all tasks
    @GetMapping("/tasks")
    public ResponseEntity<Object> home() {
        return ResponseEntity.ok().body(taskService.getAllTasks()); // res.json
    }

    // * Route to create a task
    // Including validation and error handling
    @PostMapping("/tasks")
    public ResponseEntity<Object> createTask(@Valid @RequestBody Task task, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            return ResponseEntity.status(400).body(bindingResult.getAllErrors());
        }
        return ResponseEntity.ok().body(taskService.createTask(task));
    }

    // * Route to get one task
    @GetMapping("/tasks/{id}")
    public ResponseEntity<Object> getOneTask(@PathVariable(value = "id") Long taskId) {
        return ResponseEntity.ok().body(taskService.getOneTask(taskId));
    }

    // * Route to update a task
    // Including validation and error handling
    @PutMapping("/tasks/{id}/update")
    public ResponseEntity<Object> updateTask(@PathVariable(value = "id") Long taskId, @Valid @RequestBody Task task,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            return ResponseEntity.status(400).body(bindingResult.getAllErrors());
        }
        Task savedTask = taskService.updateTask(task); // ! Need to do heavy testing on this
        return ResponseEntity.ok().body(savedTask);
    }

    // * Route to delete a task
    @DeleteMapping("/tasks/{id}/delete")
    public ResponseEntity<Object> deleteTask(@PathVariable(value = "id") Long taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.ok().body("Task deleted");
    }
}