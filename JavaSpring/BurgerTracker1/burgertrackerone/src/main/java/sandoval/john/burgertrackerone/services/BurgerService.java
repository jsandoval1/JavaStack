package sandoval.john.burgertrackerone.services;

//! Responsible for managing business/DB logic related to books
//? Reponsible for high-level business logic. It 
//? performs operations involving one or more 
//? entities, applies business rules, and 
//? provides an interface to the controller
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import sandoval.john.burgertrackerone.models.Burger;
import sandoval.john.burgertrackerone.repositories.BurgerRepository;

@Service
public class BurgerService {

    private final BurgerRepository burgerRepository;

    // Constructor for the BurgerService class with the BurgerRepository
    BurgerService(BurgerRepository burgerRepository) {
        this.burgerRepository = burgerRepository;
    }

    // Method to create a new burger and save it to the database
    public Burger createBurger(Burger burger) {
        return burgerRepository.save(burger);
    }

    // Method to retrieve all burgers from the database
    public List<Burger> findAll() {
        return burgerRepository.findAll();
    }

    // Method to find a burger by its ID
    public Burger findBurger(Long id) {
        Optional<Burger> optionalBurger = burgerRepository.findById(id);
        return optionalBurger.orElse(null);
    }

    // Method to update a burger by its ID
    public Burger updateBurger(Long id, Burger updatedBurger) {
        Optional<Burger> optionalBurger = burgerRepository.findById(id);
        if (optionalBurger.isPresent()) {
            Burger existingBurger = optionalBurger.get();
            existingBurger.setBurgerName(updatedBurger.getBurgerName());
            return burgerRepository.save(existingBurger);
        }
        return null;
    }

    // Method to delete a burger by its ID
    public void deleteBurger(Long id) {
        burgerRepository.deleteById(id);
    }

}
