package com.example.demo.service;

import com.example.demo.dto.ApiRespDto;
import com.example.demo.dto.Auth.SignupReqDto;
import com.example.demo.entity.User;
import com.example.demo.repository.Authrepository;
import com.example.demo.security.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    public Authrepository userrepo;

    @Autowired
    public BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public JwtUtil jwtUtil;

    //회원가입로직 - addUser
    /*
    * userRepo.addUser 가 Optional<User>를 반환
    * SignupReqDto.toEntity 메서드는 User 객체를 리턴
     * */
    public ApiRespDto<?> addUser(SignupReqDto signupReqDto) {
        Optional<User> optionalUser = userrepo.addUser(signupReqDto.toEntity(bCryptPasswordEncoder));

        if (optionalUser.isPresent()) {
            return new ApiRespDto<>("success", "회원가입 성공", optionalUser.get());
        } else {
            return new ApiRespDto<>("failed", "회원가입 실패", null);
        }

    }

}
