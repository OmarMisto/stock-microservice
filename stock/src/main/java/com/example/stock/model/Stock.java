package com.example.stock.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;

import java.util.ArrayList;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long stockId;
    @Column( unique = true,nullable = false)
    private long storeId;
    @OneToMany(mappedBy = "stock",cascade = CascadeType.ALL)
    @BatchSize(size = 50)
    private ArrayList<StockProduct> stockProducts;

}
