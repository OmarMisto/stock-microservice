package com.example.stock.repository;

import com.example.stock.model.Stock;
import com.example.stock.model.StockProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock,Long> {
    Optional<Stock> findByStoreId(long storeId);

    Stock findByStockStockProductId(long stockProductId);
}
