package com.example.stock.service.exception;

public class StockProductNotFoundException extends RuntimeException{
    public StockProductNotFoundException(String message){
        super(message);
    }
}
