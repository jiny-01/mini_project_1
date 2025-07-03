package com.example.demo.controller;

import com.example.demo.dto.ApiRespDto;
import com.example.demo.dto.Auth.SignupReqDto;
import com.example.demo.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupReqDto signupReqDto) {
        return ResponseEntity.ok(authService.addUser(signupReqDto));
    }
    //ResponseEntity
    // => HTTP 응답 전체를 직접 제어하고 싶을 때 사용하는 응답 래퍼 클래스

    //회원가입 여부 테스트용 페이지
    @GetMapping("/signup")
    public String signupPage() {
        return "회원가입 페이지입니다.";
    }
}
