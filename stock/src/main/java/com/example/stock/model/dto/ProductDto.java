package com.example.stock.model.dto;

import lombok.*;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class ProductDto {
    private long stockProductId;
    private int quantity;
    private BigDecimal unitPrice;
    private BigDecimal discountPercentage;
    private String country;
    private String city;
    private String deliveryLocation;
}
