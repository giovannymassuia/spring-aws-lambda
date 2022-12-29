package io.giovannymassuia.springawslambda.controller.graphql;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import io.giovannymassuia.springawslambda.model.User;
import io.giovannymassuia.springawslambda.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class UserGraphqlController {

    private final UserService userService;

    public UserGraphqlController(UserService userService) {
        this.userService = userService;
    }

    @QueryMapping
    public List<User> users() {
        return userService.findAllUsers();
    }

    @QueryMapping
    public User user(@Argument String id) {
        return userService.findUserById(id).orElseThrow();
    }

    @Component
    public class CustomExceptionResolver extends DataFetcherExceptionResolverAdapter {

        @Override
        protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
            if (ex instanceof NoSuchElementException) {
                return GraphqlErrorBuilder.newError()
                        .errorType(ErrorType.NOT_FOUND)
                        .message(ex.getMessage())
                        .path(env.getExecutionStepInfo().getPath())
                        .location(env.getField().getSourceLocation())
                        .build();
            } else {
                return null;
            }
        }
    }

}
