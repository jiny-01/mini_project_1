package com.example.demo.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private Integer userId;
    private String username;
    private String password;
    private String email;
}
