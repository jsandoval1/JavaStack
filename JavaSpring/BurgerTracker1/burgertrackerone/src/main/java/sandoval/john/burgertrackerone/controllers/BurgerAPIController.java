package sandoval.john.burgertrackerone.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sandoval.john.burgertrackerone.models.Burger;
import sandoval.john.burgertrackerone.services.BurgerService;

@RestController
public class BurgerAPIController {
    // Inject the BurgerService class into the controller
    private final BurgerService burgerService;

    // Constructor for the BurgerAPIController class with the BurgerService
    public BurgerAPIController(BurgerService burgerService) {
        this.burgerService = burgerService;
    }

    // Handle the GET request to retrieve all burgers from the database
    @GetMapping("/api/burgers")
    public List<Burger> getAllBurgers() {
        return burgerService.findAll();
    }

    // Handle the GET request to retrieve a burger by its ID
    @GetMapping("/api/burgers/{id}")
    public Burger getBurger(@PathVariable Long id) {
        // ! Maybe edit this method to retrieve a burger by its ID
        return burgerService.findBurger(id);
    }

    // Handle the POST request to create a new burger
    @PostMapping("/api/burgers")
    public Burger createBurger(
            @RequestParam(value = "Burger Name", required = true) String burgerName,
            @RequestParam(value = "Restaurant Name", required = true) String restaurantName,
            @RequestParam(value = "Rating", required = true) int rating) {
        // Create a new burger using a constructor we defined in the model and use the
        // service to save it
        Burger burger = new Burger(burgerName, restaurantName, rating);
        return burgerService.createBurger(burger);
    }
}
