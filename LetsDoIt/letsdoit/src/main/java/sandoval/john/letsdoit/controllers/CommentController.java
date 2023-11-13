package sandoval.john.letsdoit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
// import jakarta.servlet.http.HttpSession;
import sandoval.john.letsdoit.models.Comment;
import sandoval.john.letsdoit.models.Task;
import sandoval.john.letsdoit.models.User;
import sandoval.john.letsdoit.services.CommentService;
import sandoval.john.letsdoit.services.TaskService;
import sandoval.john.letsdoit.services.UserService;

@Controller
public class CommentController {

    // * Inject Comment Service
    @Autowired
    private CommentService commentService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    // * Route for creating a new comment
    // localhost:8080/tasks/{id}/comments/new // * POST
    // Check if user is logged in
    // Creates a new comment
    // Redirects to task page
    // ! Trial 1
    // @PostMapping("/comment/new")
    // public String createComment(@Valid @ModelAttribute("comment") Comment
    // comment, BindingResult result, HttpSession session, Model model) {
    // if (session.getAttribute("user") == null) {
    // return "redirect:/";
    // }
    // if (result.hasErrors()) {
    // Task taskToView = taskService.getOneTask(comment.getTask().getId());
    // model.addAttribute("task", taskToView);
    // return "ViewTask";
    // }
    // commentService.createComment(comment);
    // return "redirect:/tasks/" + comment.getTask().getId();
    // }

    // ! Trial 2
    // @PostMapping("/comment/new")
    // public String createComment(@RequestParam("commentText") String commentText,
    // @RequestParam("taskId") Long taskId, HttpSession session, Model model) {
    // if (session.getAttribute("user") == null) {
    // return "redirect:/";
    // }
    // Task task = taskService.getOneTask(taskId);
    // if (task == null) {
    // // handle error
    // }
    // Comment comment = new Comment();
    // comment.setContent(commentText);
    // comment.setTask(task);
    // // set other fields as necessary
    // commentService.createComment(comment);
    // return "redirect:/tasks/" + taskId;
    // }

    // ! Trial 3, worked for creating a comment withuser id but not handle errors
    // @PostMapping("/comment/new")
    // public String createComment(@RequestParam("commentText") String commentText,
    // @RequestParam("taskId") Long taskId,
    // @RequestParam("userId") Long userId, Model model) {
    // Task task = taskService.getOneTask(taskId);
    // User user = userService.findUser(userId);
    // if (task == null || user == null) {
    // // handle error
    // }
    // Comment comment = new Comment();
    // comment.setContent(commentText);
    // comment.setTask(task);
    // comment.setUser(user);
    // commentService.createComment(comment);
    // return "redirect:/tasks/" + taskId;
    // }

    // ! Trial 4
    // @PostMapping("/comment/new")
    // public String createComment(@RequestParam("commentText") String commentText,
    // @RequestParam("taskId") Long taskId,
    // @RequestParam("userId") Long userId, BindingResult result, Model model) {
    // if (result.hasErrors()) {
    // return "viewTask"; // return to the form page if there are validation errors
    // }
    // Task task = taskService.getOneTask(taskId);
    // User user = userService.findUser(userId);
    // if (task == null || user == null) {
    // // handle error
    // }
    // Comment comment = new Comment();
    // comment.setContent(commentText);
    // comment.setTask(task);
    // comment.setUser(user);
    // commentService.createComment(comment);
    // return "redirect:/tasks/" + taskId;
    // }

    // ! Trial 5, validation errors work but the task details are lost
    // @PostMapping("/comment/new")
    // public String createComment(@Valid @ModelAttribute("comment") Comment comment, BindingResult result,
    //         @RequestParam("taskId") Long taskId, @RequestParam("userId") Long userId) {
    //     if (result.hasErrors()) {
    //         return "ViewTask";
    //     }
    //     Task task = taskService.getOneTask(taskId);
    //     User user = userService.findUser(userId);
    //     if (task == null || user == null) {
    //         // handle error
    //     }
    //     comment.setTask(task);
    //     comment.setUser(user);
    //     commentService.createComment(comment);
    //     return "redirect:/tasks/" + taskId;
    // }

    // ! Trial 6
    @PostMapping("/comment/new")
    public String createComment(@Valid @ModelAttribute("comment") Comment comment, BindingResult result,
            @RequestParam("taskId") Long taskId, @RequestParam("userId") Long userId, Model model) {
        if (result.hasErrors()) {
            Task task = taskService.getOneTask(taskId);
            User user = userService.findUser(userId);
            model.addAttribute("task", task);
            model.addAttribute("user", user);
            return "ViewTask";
        }
        Task task = taskService.getOneTask(taskId);
        User user = userService.findUser(userId);
        if (task == null || user == null) {
            // handle error
        }
        comment.setTask(task);
        comment.setUser(user);
        commentService.createComment(comment);
        return "redirect:/tasks/" + taskId;
    }
}
