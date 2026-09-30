package com.example.stock.model.dto;

import com.example.stock.model.StockProduct;
import lombok.*;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class StockProductDto {
    private long storeId;
    private long stockId;
    private long stockProductId;
    private String productNo;
    private String brand;
    private int quantity;
    private BigDecimal unitPrice;
    private int discountPercentage;
    private boolean isAvailable;
}
