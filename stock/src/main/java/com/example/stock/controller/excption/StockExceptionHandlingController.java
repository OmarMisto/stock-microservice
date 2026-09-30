package com.example.stock.controller.excption;

import com.example.stock.model.dto.ErrorMessageResponse;
import com.example.stock.service.exception.StockNotFoundException;
import com.example.stock.service.exception.StockProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class StockExceptionHandlingController {
    @ExceptionHandler(StockNotFoundException.class)
    public ResponseEntity<?> stockNotFoundExceptionHandlerController(StockNotFoundException stockNotFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorMessageResponse
                .builder()
                        .error("Entity Not Found")
                        .status(HttpStatus.NOT_FOUND.value())
                        .message(stockNotFoundException.getMessage())
                        .date(LocalDateTime.now())
                .build()
        );
    }
    @ExceptionHandler(StockProductNotFoundException.class)
    public ResponseEntity<?> stockNotFoundExceptionHandlerController(StockProductNotFoundException stockProductNotFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorMessageResponse
                .builder()
                .error("Entity Not Found")
                .status(HttpStatus.NOT_FOUND.value())
                .message(stockProductNotFoundException.getMessage())
                .date(LocalDateTime.now())
                .build()


        );
    }
}
