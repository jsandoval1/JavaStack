package sandoval.john.letsdoit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import sandoval.john.letsdoit.models.LoginCheck;
import sandoval.john.letsdoit.models.User;
import sandoval.john.letsdoit.services.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(Model model) { // Bind empty User and LoginUser objects to the JSP to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginCheck());
        return "UserAuth";
    }

    @PostMapping("/register") // Action method of the register form
    public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
        User user = userService.register(newUser, result);
        if (result.hasErrors()) { // ! If errors are found, redirect to the index page and display form errors
            model.addAttribute("newLogin", new LoginCheck());
            return "UserAuth";
        } else { // * No errors!
            session.setAttribute("userId", user.getId()); // Store their ID from the DB in session,
            session.setAttribute("user", user); // in other words, log them in.
            return "redirect:/home";
        }
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginCheck newLogin, BindingResult result, Model model, HttpSession session) {
        User user = userService.login(newLogin, result);
        if (result.hasErrors() || user == null) { // ! If errors are found, OR user is equal to null, direct to the index page and display form errors
            model.addAttribute("newUser", new User());
            return "UserAuth";
        } else { // * No errors!
            session.setAttribute("userId", user.getId());
            session.setAttribute("user", user); // Store their ID from the DB in session, in other words, log them in.
            return "redirect:/home";
        }
    }

    // @GetMapping("/home") //! Becomes /books?
    // // Method to check if user is in session to access pages
    // public String home(HttpSession session) { //! Need this later for session check 
    //     if (session.getAttribute("userId") == null) {
    //         return "redirect:/";
    //     }
    //     return "home";
    // }

    @GetMapping("/logout") // Logout method
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}