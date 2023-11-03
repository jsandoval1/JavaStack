package sandoval.john.burgertrackertwo.repositories;
//! Responsible for being entry point of  DB operations
// ? responsible for low-level database interactions, 
//? such as reading and writing data to and from the 
//? database. Usually CRUD operations and querying the database.

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import sandoval.john.burgertrackertwo.models.Burger;

public interface BurgerRepository extends CrudRepository<Burger, Long> {
    // Method to retrieve all burgers from the database
    List<Burger> findAll();

    // // Method to find burgers with containing the search string
    // List<Burger> findByBurgerNameContaining(String search);

    // // Method to count how many burgers contain a certain string
    // Long countByBurgerNameContaining(String search);

    // // Method to delete a burger that contains the search string
    // Long deleteByBurgerNameContaining(String search);

}


//! Try deleting the prior lines of code to see how to use the repository