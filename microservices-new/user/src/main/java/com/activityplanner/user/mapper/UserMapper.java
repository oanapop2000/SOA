package com.activityplanner.user.mapper;

import com.activityplanner.user.dto.UserDTO;
import com.activityplanner.user.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDTO convertToDTO(User entity) {
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        return dto;
    }
}
