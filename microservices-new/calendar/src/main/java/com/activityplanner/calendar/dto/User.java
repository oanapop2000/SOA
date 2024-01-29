package com.activityplanner.calendar.dto;

import com.activityplanner.calendar.dto.enums.UserRole;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private Long id;

    private String username;

    private String password;

    private String email;

    private String firstName;

    private String lastName;

    private UserRole userRole;
}
