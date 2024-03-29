package com.activityplanner.user.repository;

import com.activityplanner.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    Optional<User> findById(Long id);
    Optional<User> findByUsernameAndPassword(String username, String password);
}
