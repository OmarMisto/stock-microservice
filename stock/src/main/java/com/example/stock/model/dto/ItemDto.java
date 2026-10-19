package com.example.stock.model.dto;

import lombok.*;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ItemDto {
    private long stockProductId;
    private int quantity;
    private BigDecimal unitPrice;
    private long discountPercentage;
}
