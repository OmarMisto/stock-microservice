package com.example.stock.service.exception;

public class StockOutOfRequiredQuantityException extends RuntimeException {
    public StockOutOfRequiredQuantityException(String s) {
        super(s);
    }
}
