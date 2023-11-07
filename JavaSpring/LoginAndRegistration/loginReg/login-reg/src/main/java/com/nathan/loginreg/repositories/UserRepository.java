package com.nathan.loginreg.repositories;

// ! We do not need to make a repository for LoginUser as we only want to save instances of User to the database.

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.nathan.loginreg.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
