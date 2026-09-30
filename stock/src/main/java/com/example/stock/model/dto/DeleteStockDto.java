package com.example.stock.model.dto;

import lombok.*;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class DeleteStockDto {
    private long storeId;
    private long stockId;
    private boolean isDeleted;
    private LocalDateTime deleteDate;
}
