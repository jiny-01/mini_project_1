package com.example.demo.dto.Auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginReqDto {
    private String username;
    private String password;

}
