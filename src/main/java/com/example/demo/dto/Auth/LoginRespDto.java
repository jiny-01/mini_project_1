package com.example.demo.dto.Auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginRespDto {
    private String username;
    private String jwtToken;

}
