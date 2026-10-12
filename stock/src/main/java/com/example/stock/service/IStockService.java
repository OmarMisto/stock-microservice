package com.example.stock.service;

import com.example.stock.model.dto.*;

import java.util.ArrayList;

public interface IStockService {
    public StockDto createStockService(long storeId);
    public ArrayList<GetStockProductDto> getStockProducts(long storeId);
    public GetStockProductDto getStockProduct(long stockProductId);
    public DeleteStockDto doDeleteStockService(long storeId);
    public StockProductDto addStockProductService(AddStockProductDto addStockProductDto);
    public void removeStockProduct(long storeId,long productId);
    public StockProductDto updateStockProduct(UpdateStockProductDto updateStockProductDto);
}
