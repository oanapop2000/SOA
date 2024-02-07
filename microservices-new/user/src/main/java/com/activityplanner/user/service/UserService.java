package com.activityplanner.user.service;

import com.activityplanner.user.model.User;
import com.activityplanner.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getUserByUsername(String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User not found!");
        }
        log.info("User {} is found", optionalUser.get().getId());
        return optionalUser.get();
    }

    public User getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User not found!");
        }
        log.info("User {} is found", optionalUser.get().getId());
        return optionalUser.get();
    }

    public User getUserByUsernameAndPassword(String username, String password) {
        Optional<User> optionalUser = userRepository.findByUsernameAndPassword(username, password);
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("Username or password invalid!");
        }
        log.info("User {} is found", optionalUser.get().getId());
        return optionalUser.get();
    }

    public User createUser(User user) {
        User savedUser = userRepository.save(user);
        log.info("User {} is saved", savedUser.getId());
        return savedUser;
    }
}
