package com.example.stock.model.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class ReducedProductsEvent {
    private long orderId;
    private List<ItemDto> items;
    private final LocalDateTime date=LocalDateTime.now();
    private String event;
}
