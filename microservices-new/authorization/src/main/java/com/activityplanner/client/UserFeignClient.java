package com.activityplanner.client;

import com.activityplanner.dto.UserDTO;
import com.activityplanner.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-service", url = "${user-service.url}")
public interface UserFeignClient {

    @PostMapping("/register")
    ResponseEntity<UserDTO> createUser(@RequestBody User user);

//    @PostMapping("/login")
//    ResponseEntity
}
