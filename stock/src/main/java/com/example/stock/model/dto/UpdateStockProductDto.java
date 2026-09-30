package com.example.stock.model.dto;

import lombok.*;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class UpdateStockProductDto {
    private long stockProductId;
    private int quantity;
    private BigDecimal unitPrice;
    private int discountPercentage;
}
