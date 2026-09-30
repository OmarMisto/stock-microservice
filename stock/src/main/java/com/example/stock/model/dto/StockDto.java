package com.example.stock.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class StockDto {
    private long stockId;
    private long storeId;
}
