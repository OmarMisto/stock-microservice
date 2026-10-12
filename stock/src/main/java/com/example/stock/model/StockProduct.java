package com.example.stock.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class StockProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="stock_product_gen" )
    @SequenceGenerator(name = "stock_product_gen",allocationSize = 30,sequenceName = "stock_product_seq")
    private long stockProductId;
    @Column(nullable = false,unique = true)
    private String productNo;
    private String brand;
    private int quantity;
    private BigDecimal unitPrice;
    private long discountPercentage;
    private boolean isAvailable;
    @ManyToOne
    @JoinColumn(name = "stockId")
    private Stock stock;
}
