package com.activityplanner.user.service;

import com.activityplanner.user.model.User;
import com.activityplanner.user.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class RegistrationService {

    private final UserRepository userRepository;

    public RegistrationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(User user) {
        userRepository.save(user);
    }
}
