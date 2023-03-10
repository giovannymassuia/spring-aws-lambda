package io.giovannymassuia.springawslambda.controller.rest;

import io.giovannymassuia.springawslambda.model.User;
import io.giovannymassuia.springawslambda.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
