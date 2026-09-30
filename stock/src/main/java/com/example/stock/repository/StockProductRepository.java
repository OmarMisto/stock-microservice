package com.example.stock.repository;

import com.example.stock.model.StockProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockProductRepository extends JpaRepository<StockProduct,Long> {
    Optional<StockProduct> findByProductNo(String productNo);
}
