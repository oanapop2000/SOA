package com.activityplanner.user.service;

import com.activityplanner.user.model.User;
import com.activityplanner.user.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByUsername(String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User not found!");
        }

        return optionalUser.get();
    }

    public User getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User not found!");
        }

        return optionalUser.get();
    }

    public User getUserByUsernameAndPassword(String username, String password) {
        Optional<User> optionalUser = userRepository.findByUsernameAndPassword(username, password);
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("Username or password invalid!");
        }

        return optionalUser.get();
    }

    public void registerUser(User user) {
        userRepository.save(user);
    }
}
