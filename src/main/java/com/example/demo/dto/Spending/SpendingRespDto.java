package com.example.demo.dto.Spending;

import java.time.LocalDateTime;

// Spending (소비기록 등록) 응답용 DTO
public class SpendingRespDto {
    private Integer spendingLogId;
    private int amount;
    private String category;
    private String memo;
    private LocalDateTime createDt;
}
