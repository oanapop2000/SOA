package com.activityplanner.calendar.dto;

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
}
