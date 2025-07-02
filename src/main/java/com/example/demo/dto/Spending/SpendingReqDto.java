package com.example.demo.dto.Spending;

import com.example.demo.entity.Spending;

import java.time.LocalDateTime;

//Spending(소비기록) 등록 요청 DTO
public class SpendingReqDto {
    private Integer amount;
    private String category;
    private String memo;
    private LocalDateTime createDt;

}
