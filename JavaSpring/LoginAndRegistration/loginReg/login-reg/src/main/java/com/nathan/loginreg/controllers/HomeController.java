package com.nathan.loginreg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nathan.loginreg.models.LoginUser;
import com.nathan.loginreg.models.User;
import com.nathan.loginreg.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(Model model) { // Bind empty User and LoginUser objects to the JSP to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index";
    }

    @PostMapping("/register") // Action method of the register form
    public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
        User user = userService.register(newUser, result);
        if (result.hasErrors()) { // ! If errors are found, redirect to the index page and display form errors
            model.addAttribute("newLogin", new LoginUser());
            return "index";
        } // * No errors!
        session.setAttribute("userId", user.getId()); // Store their ID from the DB in session,
        session.setAttribute("user", user); // in other words, log them in.
        return "redirect:/home";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
        User user = userService.login(newLogin, result);
        if (result.hasErrors() || user == null) { // ! If errors are found, OR user is equal to null, direct to the index page and display form errors
            model.addAttribute("newUser", new User());
            return "index";
        } else { // * No errors!
            session.setAttribute("userId", user.getId());
            session.setAttribute("user", user); // Store their ID from the DB in session, in other words, log them in.
            return "redirect:/home";
        }
    }

    @GetMapping("/home") // Method to check if user is in session to access pages
    public String home(HttpSession session) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/";
        }
        return "home";
    }

    @GetMapping("/logout") // Logout method
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
