package sandoval.john.letsdoit.controllers;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// import sandoval.john.letsdoit.services.TaskService;

@Controller
public class TaskController {
    
    // * Inject Task Service
    // @Autowired
    // private TaskService taskService;

    // // * Route for index
    // @GetMapping("/")
    // public String index() {
    //     return "index";
    // }

    // * Route for home
    @GetMapping("/home")
    public String home() {
        return "Home";
    }
}
