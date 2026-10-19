package com.example.stock.service.implementation;

import com.example.stock.model.StockProduct;
import com.example.stock.model.dto.*;
import com.example.stock.repository.StockProductRepository;
import com.example.stock.service.IStockProductsService;
import com.example.stock.service.exception.StockProductNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service
@RequiredArgsConstructor
public class StockProductService implements IStockProductsService {
    private final StockProductRepository stockProductRepository;
    private final KafkaStockReservedProducer kafkaReducedProductProducer;
    @Override
    public List<StockProduct> listStockProductsByAllId(List<Long> ids) {
        return stockProductRepository.findAllById(ids);
    }

    @Override
    public void saveAllProducts(List<StockProduct> stockProducts) {
        stockProductRepository.saveAll(stockProducts);


    }

    @Override
    public GetStockProductDto getStockProduct(long stockProductId) {
        StockProduct stockProduct=stockProductRepository.findById(stockProductId).orElseThrow(()->new StockProductNotFoundException("product not found"));
        return GetStockProductDto.builder()
                .stockProductId(stockProduct.getStockProductId())
                .productNo(stockProduct.getProductNo())
                .brand(stockProduct.getBrand())
                .quantity(stockProduct.getQuantity())
                .unitPrice(stockProduct.getUnitPrice().multiply(BigDecimal.valueOf(stockProduct.getDiscountPercentage())))
                .isAvailable(stockProduct.isAvailable())
                .build();
    }

}
