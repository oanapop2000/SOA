package com.activityplanner.user.controller;

import com.activityplanner.user.model.User;
import com.activityplanner.user.service.RegistrationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
@Slf4j
@Tag(name = "/register", description = "Provides REST functionality for users")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        registrationService.registerUser(user);
        return ResponseEntity.ok("User successfully registered");
    }
}
