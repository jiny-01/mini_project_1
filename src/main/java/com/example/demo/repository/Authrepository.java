package com.example.demo.repository;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.dao.DuplicateKeyException;

import java.util.Optional;

@Repository
@Data
public class Authrepository {

    @Autowired
    private UserMapper userMapper;

    //회원가입 - 사용자 추가
    /*
    * userMapper.addUser(user) 호출 시 MyBatis useGeneratedKeys=true 설정 덕분에
    DB에서 생성된 PK가 자동으로 user.userId 필드에 세팅
    * 중복키 예외가 발생하면 빈 Optional을 리턴해서 호출 쪽에서 실패 여부 판단 가능
    * 성공하면 Optional.of(user)로 실제 생성된 사용자 객체 반환
     */
    public Optional<User> addUser(User user) {
        try{
            userMapper.addUser(user);
        } catch (DuplicateKeyException e) {
            return Optional.empty();
        }
        return Optional.of(user);
    }









}
