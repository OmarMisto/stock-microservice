package com.example.stock.service.implementation;

import com.example.stock.model.Stock;
import com.example.stock.model.StockProduct;
import com.example.stock.model.dto.*;
import com.example.stock.repository.StockProductRepository;
import com.example.stock.repository.StockRepository;
import com.example.stock.service.IStockService;
import com.example.stock.service.exception.StockNotFoundException;
import com.example.stock.service.exception.StockProductNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class StockService implements IStockService {
    private final StockRepository stockRepository;
    private final StockProductRepository stockProductRepository;
    public StockService(StockRepository stockRepository,StockProductRepository stockProductRepository){
        this.stockRepository=stockRepository;
        this.stockProductRepository=stockProductRepository;
    }
    @Override
    public StockDto createStockService(long storeId) {
        Stock stock= stockRepository.save(Stock.builder().stockId(storeId).build());
        return StockDto.builder().stockId(stock.getStockId()).storeId(stock.getStoreId()).build();
    }
    @Override
    public ArrayList<GetStockProductDto> getStockProducts(long storeId) {
        return null;
    }

    @Override
    public GetStockProductDto getStockProduct(String productNo) {
        return null;
    }

    @Override
    public DeleteStockDto doDeleteStockService(long storeId) {
        return null;
    }

    @Override
    @Transactional
    public StockProductDto addStockProductService(AddStockProductDto addStockProductDto) {
      Stock stock= stockRepository.findById(addStockProductDto.getStockId()).orElseThrow(()-> new StockNotFoundException("stock not found"));
      stock.getStockProducts()
              .add(StockProduct
                      .builder()
                      .brand(addStockProductDto.getBrand())
                      .productNo(addStockProductDto.getProductNo())
                      .quantity(addStockProductDto.getQuantity())
                      .unitPrice(addStockProductDto.getUnitPrice())
                      .discountPercentage(addStockProductDto.getDiscountPercentage())
                      .isAvailable(addStockProductDto.isAvailable())
                      .build());
       stockRepository.save(stock);
       StockProduct stockProduct= stockProductRepository.findByProductNo(addStockProductDto.getProductNo()).orElseThrow(()->new StockProductNotFoundException("stock product not found"));
       return StockProductDto.builder()
               .stockId(stockProduct.getStock().getStockId())
               .storeId(stockProduct.getStock().getStoreId())
               .stockProductId(stockProduct.getStockProductId())
               .productNo(stockProduct.getProductNo())
               .brand(stockProduct.getBrand())
               .unitPrice(stockProduct.getUnitPrice())
               .quantity(stockProduct.getQuantity())
               .discountPercentage(stockProduct.getDiscountPercentage())
               .isAvailable(stockProduct.isAvailable())
               .build();
    }

    @Override
    @Transactional
    public void removeStockProduct(long storeId,long productId) {
//        Stock stock= stockRepository.findByStoreId(storeId).orElseThrow(()-> new StockNotFoundException("store not found"));
//        stock.getStockProducts().removeIf(stockProduct -> stockProduct.getProductId()==productId);
//        stockRepository.save(stock);
    }
    @Override
    public StockProductDto updateStockProduct(UpdateStockProductDto updateStockProductDto) {
        StockProduct stockProduct= stockProductRepository.findById(updateStockProductDto.getStockProductId()).orElseThrow(()->new StockProductNotFoundException("stock product not found"));

        return null;
    }
}
