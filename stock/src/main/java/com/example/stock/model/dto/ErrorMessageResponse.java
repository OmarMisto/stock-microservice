package com.example.stock.model.dto;

import lombok.*;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class ErrorMessageResponse {
    private String error;
    private String message;
    private int status;
    private LocalDateTime date;

}
