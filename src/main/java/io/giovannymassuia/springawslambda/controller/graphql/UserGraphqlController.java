package io.giovannymassuia.springawslambda.controller.graphql;

import graphql.kickstart.tools.GraphQLQueryResolver;
import io.giovannymassuia.springawslambda.model.User;
import io.giovannymassuia.springawslambda.service.UserService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserGraphqlController implements GraphQLQueryResolver {

    private final UserService userService;

    public UserGraphqlController(UserService userService) {
        this.userService = userService;
    }

    public List<User> users() {
        return userService.findAllUsers();
    }

    public User user(String id) {
        return userService.findUserById(id).orElseThrow();
    }

}
