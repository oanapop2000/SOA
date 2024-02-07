package com.activityplanner.controller;

import com.activityplanner.dto.UserDTO;
import com.activityplanner.model.LoginRequest;
import com.activityplanner.model.User;
import com.activityplanner.service.AuthorizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authorization")
@RequiredArgsConstructor
public class AuthorizationController {
    private final AuthorizationService authorizationService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody User user) {
        UserDTO response = authorizationService.registerUser(user);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody LoginRequest loginRequest) {

    }
}
