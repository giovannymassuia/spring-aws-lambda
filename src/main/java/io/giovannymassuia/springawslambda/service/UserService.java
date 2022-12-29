package io.giovannymassuia.springawslambda.service;

import io.giovannymassuia.springawslambda.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final List<User> users = List.of(
            new User("1", "Admin", true),
            new User("2", "User 1", false),
            new User("3", "User 2", false),
            new User("4", "User 3", false)
    );

    public List<User> findAllUsers() {
        return this.users;
    }

    public Optional<User> findUserById(String userId) {
        return this.users.stream().filter(u -> u.getId().equals(userId)).findFirst();
    }
}
