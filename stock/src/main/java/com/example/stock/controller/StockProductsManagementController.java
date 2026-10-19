package com.example.stock.controller;

import com.example.stock.model.dto.GetStockProductDto;
import com.example.stock.service.IStockProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/stock/products")
@RequiredArgsConstructor
public class StockProductsManagementController {
    private final IStockProductsService iStockProductsService;
    @GetMapping("get/{stockProductId}")
    public ResponseEntity<GetStockProductDto> getStockProductByIdController(@PathVariable("stockProductId")long stockProductId){
        return ResponseEntity.ok().body(iStockProductsService.getStockProduct(stockProductId));
    }
}
