package sandoval.john.burgertrackerone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import sandoval.john.burgertrackerone.models.Burger;
import sandoval.john.burgertrackerone.services.BurgerService;

@Controller
public class BurgerController {

    @Autowired
    BurgerService burgerService;

    // Handle GET requests to the "/burgers" URL
    @GetMapping("/burgers")
    public String getBurgers(Model model) {
        model.addAttribute("burgers", burgerService.findAll());

        // Add an empty Burger object to the model for the form
        model.addAttribute("burger", new Burger());

        return "ViewAllBurgers";
    }

    // Handle GET requests to view one specific burger
    @GetMapping("/burgers/{burgerId}")
    public String getBurger(@PathVariable("burgerId") Long burgerId, Model model) {
        Burger burger = burgerService.findBurger(burgerId);
        model.addAttribute("burger", burger);
        return "ViewBurger";
    }

    // Handle POST requests to create a new burger
    @PostMapping("/burgers")
    public String createBurger(@Valid Burger burger, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            // Validation errors occurred, add them to the model
            model.addAttribute("burgers", burgerService.findAll()); // Add the list of burgers
            model.addAttribute("burger", burger);
        } else {
            burgerService.createBurger(burger);
            model.addAttribute("burgers", burgerService.findAll()); // Update the list of burgers
            model.addAttribute("burger", new Burger()); // Clear the burger object for a new entry
        }
        return "ViewAllBurgers"; // Return the same view, since we have our form and getAll on same page
    }
}
