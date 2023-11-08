package sandoval.john.bookclub.repositories;

import java.util.List;

// ! We do not need to make a repository for LoginUser as we only want to save instances of User to the database.

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import sandoval.john.bookclub.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);

    List<User> findAll(); // ! May or may not need this 

}