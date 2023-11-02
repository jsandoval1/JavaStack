package sandoval.john.burgertrackerone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String getBurgers(@ModelAttribute Burger burger, Model model) { // Add the list of burgers to the model we are sending to the view
        model.addAttribute("burgers", burgerService.findAll()); // Create the list of burgers, these are passed into the Model model which gets passed into the ViewAllBurgers page
        return "ViewAllBurgers";
    }    

    // Handle GET requests to view one specific burger
    @GetMapping("/burgers/{burgerId}")
    public String getBurger(@PathVariable("burgerId") Long burgerId, Model model) { // @PathVariable("burgerId") is what we grab from the model, Long burgerId is the ID holds value extracted from PathVar, model is the model we are sending to the view
        Burger burger = burgerService.findBurger(burgerId); // Declaring burger as a variable to hold the burger we are looking for
        model.addAttribute("burger", burger); // Add the above declared burger to the model
        return "ViewBurger";
    }

    // Handle POST requests to create a new burger
    @PostMapping("/burgers")
    public String createBurger(@Valid @ModelAttribute Burger burger, BindingResult bindingResult, Model model) { // @Valid is validating the object passed into the form, bindingResult is the result of the validation. ModelAattributes is the burger instance. Model model is the model we are sending to the view.
        if (bindingResult.hasErrors()) {
            //! Validation errors occurred, add them to the model
            model.addAttribute("burgers", burgerService.findAll()); // Add the list of burgers for when we render the ViewAllBurgers page, since it failed.
            model.addAttribute("burger", burger);
            return "ViewAllBurgers"; // Return the same view, since we have our form and getAll on the same page
        } else { 
            //* No validation errors occurred, add the new burger to the database
            burgerService.createBurger(burger);
        }
        return "redirect:/burgers"; //* redirect is needed because the form if page is refreshed the burger is re-added to the database
    }
}
