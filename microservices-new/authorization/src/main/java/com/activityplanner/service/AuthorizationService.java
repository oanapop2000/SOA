package com.activityplanner.service;

import com.activityplanner.client.UserFeignClient;
import com.activityplanner.dto.UserDTO;
import com.activityplanner.model.User;
import com.activityplanner.repository.AuthorizationRepository;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
@RequiredArgsConstructor
public class AuthorizationService {
    private final AuthorizationRepository authorizationRepository;
    private final UserFeignClient userFeignClient;

//    public UserDTO login(String username, String password) {
//        Optional<User> optionalUser = userFeignClient.findByUsernameAndPassword(username, password);
//        if (optionalUser.isEmpty()) {
//            throw new RuntimeException("Username or password invalid!");
//        }
//        log.info("User {} is found", optionalUser.get().getId());
//        return optionalUser.get();
//    }

    public UserDTO registerUser(User user) {
        ResponseEntity<UserDTO> response = userFeignClient.createUser(user);

        if(!response.hasBody()) {
            throw new RuntimeException("Error while creating user");
        }
        return response.getBody();
    }

//    public UserDTO login(String username, String password) {
//        UserDTO
//    }
}
