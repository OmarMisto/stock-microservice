package com.example.stock.service;

import com.example.stock.model.StockProduct;
import com.example.stock.model.dto.GetStockProductDto;

import java.util.List;

public interface IStockProductsService {
    public List<StockProduct> listStockProductsByAllId(List<Long> ids);
    public void saveAllProducts(List<StockProduct> stockProducts);

    public GetStockProductDto getStockProduct(long stockProductId);
}
