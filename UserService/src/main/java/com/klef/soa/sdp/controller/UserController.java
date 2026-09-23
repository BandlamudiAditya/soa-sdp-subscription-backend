package com.klef.soa.sdp.controller;

import com.klef.soa.sdp.entity.User;
import com.klef.soa.sdp.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User Service", description = "User registration, login and user management APIs")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @Operation(
        summary = "Register a new user",
        description = "Creates a new user account"
    )
    public User register(@RequestBody User user) {

        return userService.register(user);
    }

    @PostMapping("/login")
    @Operation(
        summary = "User login",
        description = "Authenticates user and returns JWT token"
    )
    public String login(
            @RequestParam String username,
            @RequestParam String password) {

        return userService.login(username, password);
    }

    @GetMapping("/{username}")
    @Operation(
        summary = "Get user details",
        description = "Returns user details for the given username"
    )
    public User getUser(@PathVariable String username) {

        return userService.getUser(username);
    }
}