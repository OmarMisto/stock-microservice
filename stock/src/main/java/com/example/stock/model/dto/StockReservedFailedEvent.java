package com.example.stock.model.dto;

import lombok.*;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class StockReservedFailedEvent {
    private long orderId;
    private String event;
    private LocalDateTime date;
    private String message;
}
