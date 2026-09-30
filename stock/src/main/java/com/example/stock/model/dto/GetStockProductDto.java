package com.example.stock.model.dto;



import lombok.*;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class GetStockProductDto {
    private long stockProductId;
    private long productId;
    private String productNo;
    private String brand;
    private int quantity;
    private BigDecimal unitPrice;
    private int discountPercentage;
    private boolean isAvailable;
}
