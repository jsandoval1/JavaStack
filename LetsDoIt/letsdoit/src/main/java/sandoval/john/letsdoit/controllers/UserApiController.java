package sandoval.john.letsdoit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sandoval.john.letsdoit.models.User;
import sandoval.john.letsdoit.services.UserService;

@RestController
@RequestMapping("/api")
public class UserApiController {

    // * Inject User Service
    @Autowired
    private UserService userService;

    // * Route to get all users
    @GetMapping("/users")
    public List<User> getallUsers() {
        return userService.allUsers();
    }
    
    // * Route to get one user
    @GetMapping("/users/{id}")
    public User getOneUser(@PathVariable Long id) {
        return userService.findUser(id);
    }
}
