package sandoval.john.server.repositories;

import java.util.List;
// import java.util.Optional; // ? For Spring Security, undo this later

import org.springframework.data.repository.CrudRepository;

import sandoval.john.server.models.User;

// @Repository, no longer need to mark as repository
public interface UserRepository extends CrudRepository<User, Long> {
    // Optional<User> findByEmail(String email); // ? For Spring Security training, undo this later

    List<User> findAll(); // ! May or may not need this 

    // ? For Spring Security, undo this later
    // // * Find user by id
    // User findById(long id);

    // // * Find user by first name
    // List<User> findByFirstName(String firstName);

    // // * Find user by last name
    // List<User> findByLastName(String lastName);

    // ? For Spring Security 
    User findByUsername(String username);

}