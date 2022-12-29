package io.giovannymassuia.springawslambda.controller.rest;

import io.giovannymassuia.springawslambda.model.User;
import io.giovannymassuia.springawslambda.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> users() {
        return userService.findAllUsers();
    }

    @GetMapping("{userId}")
    public ResponseEntity<User> user(@PathVariable String userId) {
        return userService.findUserById(userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
