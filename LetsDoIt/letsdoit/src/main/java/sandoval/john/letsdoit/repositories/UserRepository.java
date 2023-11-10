package sandoval.john.letsdoit.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
// import org.springframework.stereotype.Repository;

import sandoval.john.letsdoit.models.User;

// @Repository, no longer need to mark as repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);

    List<User> findAll(); // ! May or may not need this 

}