package com.example.course_registrstion_system.payload;

import lombok.Data;

@Data
public class JwtAuthRequest {
    private String username;// consider email as a username in our project
    private String password;
}
