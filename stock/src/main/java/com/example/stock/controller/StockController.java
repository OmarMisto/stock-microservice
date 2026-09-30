package com.example.stock.controller;

import com.example.stock.model.dto.AddStockProductDto;
import com.example.stock.model.dto.UpdateStockProductDto;
import com.example.stock.service.IStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/stock")
@RequiredArgsConstructor
public class StockController {
    private final IStockService iStockService;
    @PostMapping("/create/{storeId}")
    public ResponseEntity<?> createStockController(@PathVariable("storeId") long storeId){
        return ResponseEntity.status(HttpStatus.CREATED).body(iStockService.createStockService(storeId));
    }
    @DeleteMapping("delete/{storeId}")
    public ResponseEntity<?>deleteStockController(@PathVariable(name = "storeId")long storeId){
        return ResponseEntity.ok("");
    }
    @GetMapping("get/{storeId}")
    public ResponseEntity<?>getStockProductsController(@PathVariable(name = "storeId")long storeId){
        return ResponseEntity.ok("");
    }
    @PostMapping("/add/product")
    public ResponseEntity<?>addStockProductController(@RequestBody AddStockProductDto addStockProductDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(iStockService.addStockProductService(addStockProductDto));
    }
    @DeleteMapping("/remove/product/{productId}")
    public ResponseEntity<?>removeStockProductController(@PathVariable long productId){
        return ResponseEntity.ok("");
    }
    @PatchMapping("/update/product")
    public ResponseEntity<?> updateStockProductController(@RequestBody UpdateStockProductDto updateStockProductDto){
        return ResponseEntity.ok("");
    }
}
