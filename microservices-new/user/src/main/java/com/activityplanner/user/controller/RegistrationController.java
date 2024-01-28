package com.activityplanner.user.controller;//package com.activityplanner.user.controller;
//
//import com.activityplanner.user.model.User;
//import com.activityplanner.user.service.RegistrationService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/register")
//public class RegistrationController {
//
//    private final RegistrationService registrationService;
//
//    public RegistrationController(RegistrationService registrationService) {
//        this.registrationService = registrationService;
//    }
//
//    @PostMapping
//    public ResponseEntity<String> registerUser(@ModelAttribute User user) {
//        registrationService.registerUser(user);
//        return ResponseEntity.ok("User successfully registered");
//    }
//}
