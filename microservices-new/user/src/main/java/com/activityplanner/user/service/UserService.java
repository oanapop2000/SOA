package com.activityplanner.user.service;

import com.activityplanner.user.dto.UserDTO;
import com.activityplanner.user.mapper.UserMapper;
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
    private final UserMapper userMapper;

    public UserDTO getUserByUsername(String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User not found!");
        }
        UserDTO response = userMapper.convertToDTO(optionalUser.get());
        log.info("User {} is found", response.getId());
        return response;
    }

    public UserDTO getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User not found!");
        }
        UserDTO response = userMapper.convertToDTO(optionalUser.get());
        log.info("User {} is found", response.getId());
        return response;
    }

    public UserDTO getUserByUsernameAndPassword(String username, String password) {
        Optional<User> optionalUser = userRepository.findByUsernameAndPassword(username, password);
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("Username or password invalid!");
        }
        UserDTO response = userMapper.convertToDTO(optionalUser.get());
        log.info("User {} is found", response.getId());
        return response;
    }

    public UserDTO createUser(User user) {
        User savedUser = userRepository.save(user);
        return userMapper.convertToDTO(savedUser);
    }
}
