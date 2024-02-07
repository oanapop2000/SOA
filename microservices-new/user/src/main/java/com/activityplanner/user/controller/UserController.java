package com.activityplanner.user.controller;

import com.activityplanner.user.model.User;
import com.activityplanner.user.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
@Tag(name = "/users", description = "Provides REST functionality for users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable(value = "username") String username) {
        return ResponseEntity.ok(userService.getUserByUsername(username));
    }

    @GetMapping
    public User getUserById(@RequestParam Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public User getUserByUsernameAndPassword(@RequestBody User user) {
        return userService.getUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = userService.createUser(user);
        return ResponseEntity.ok(newUser);
    }
}
