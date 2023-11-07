package com.nathan.loginreg.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.nathan.loginreg.models.LoginUser;
import com.nathan.loginreg.models.User;
import com.nathan.loginreg.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {

        // Additional validations!
        // - Reject if email is taken (present in database)
        if (userRepository.findByEmail(newUser.getEmail()).isPresent()) {
            result.rejectValue("email", "Email", "What are you doing?? you already registered");
        }

        // - Reject if password doesn't match confirmation
        if (!newUser.getPassword().equals(newUser.getConfirm())) {
            result.rejectValue("password", "Password", "Dude, learn to type! Your password dont match!");
        }

        // - Return null if result has errors
        if (result.hasErrors()) {
            return null;
        }

        // - Hash passowrd
        String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        System.out.println(hashed);

        // set password
        newUser.setPassword(hashed);

        // - save user to database
        return userRepository.save(newUser);
    }

    public User login(LoginUser newLoginObject, BindingResult result) {
        // TO-DO: Additional validations!

        // Find user in the DB by email
        Optional<User> user = userRepository.findByEmail(newLoginObject.getEmail());

        // Reject if NOT present
        // Reject if BCrypt password match fails
        if (!user.isPresent()) {
            result.rejectValue("email", "logEmail", "Invalid credentials");
        } else if (!BCrypt.checkpw(newLoginObject.getPassword(), user.get().getPassword())) {
            result.rejectValue("password", "logPassword", "Invalid credentials");
        }

        // Return null if result has errors
        if (result.hasErrors()) {
            return null;
        }

        // Otherwise, return the user object
        return user.get();
    }

}
