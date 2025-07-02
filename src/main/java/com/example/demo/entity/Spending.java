package com.example.demo.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Spending {
    private Integer spendingLogId;
    private Integer userId;
    private String amount;
    private String category;
    private LocalDateTime createDt;
    private LocalDateTime updateDt;
}
