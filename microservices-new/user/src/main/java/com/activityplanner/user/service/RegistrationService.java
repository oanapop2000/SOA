package com.activityplanner.user.service;//package com.activityplanner.user.service;
//
//import com.activityplanner.user.helper.SaltGenerator;
//import com.activityplanner.user.model.User;
//import com.activityplanner.user.repository.UserRepository;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//@Component
//public class RegistrationService {
//
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    public RegistrationService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    public void registerUser(User user) {
//        user.setUsername(user.getUsername());
//
//        String salt = SaltGenerator.generateUniqueSalt();
//
//        String saltedPassword = user.getPassword().concat(salt);
//
//        String hashedPassword = passwordEncoder.encode(saltedPassword);
//
//        user.setPassword(hashedPassword);
//
//        userRepository.save(user);
//    }
//}
