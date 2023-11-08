package sandoval.john.bookclub.services;


import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import sandoval.john.bookclub.models.LoginUser;
import sandoval.john.bookclub.models.User;
import sandoval.john.bookclub.repositories.UserRepository;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // * user Register method: 
    public User register(User newUser, BindingResult result) {
        if (userRepository.findByEmail(newUser.getEmail()).isPresent()) { // Reject if email is taken (present in database)
            result.rejectValue("email", "Email", "What are you doing?? you already registered");
        } // Reject if password doesn't match confirmation
        if (!newUser.getPassword().equals(newUser.getConfirm())) {
            result.rejectValue("password", "Password", "Dude, learn to type! Your password dont match!");
        } // Return null if result has errors
        if (result.hasErrors()) {
            return null;
        }
        // Hashing the passowrd
        String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        System.out.println(hashed);
        newUser.setPassword(hashed); // set password
        return userRepository.save(newUser); // - save user to database
    }

    // * user Login method: 
    public User login(LoginUser newLoginObject, BindingResult result) {
        Optional<User> user = userRepository.findByEmail(newLoginObject.getEmail()); // Find user in the DB by email
        if (!user.isPresent()) {
            result.rejectValue("email", "logEmail", "Invalid credentials"); // Reject if NOT present
        } else if (!BCrypt.checkpw(newLoginObject.getPassword(), user.get().getPassword())) {
            result.rejectValue("password", "logPassword", "Invalid credentials"); // Reject if BCrypt password match fails
        }
        if (result.hasErrors()) { // Return null if result has errors
            return null;
        }
        return user.get(); // Otherwise, return the user object
    }

    //! Extend service for one to many books????
    
}