package com.example.stock.service.implementation;

import com.example.stock.model.StockProduct;
import com.example.stock.model.dto.ItemDto;
import com.example.stock.model.dto.OrderEvent;
import com.example.stock.model.dto.ReducedProductsEvent;
import com.example.stock.model.dto.StockReservedFailedEvent;
import com.example.stock.service.IStockProductsService;
import com.example.stock.service.exception.StockOutOfRequiredQuantityException;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KafkaConsumeService {
    private final IStockProductsService stockProductsService;
    private final KafkaStockReservedProducer kafkaStockReservedProducer;
    private final KafkaStockReservedFailedProducer kafkaStockReservedFailedProducer;
    @KafkaListener(topics = "order-created",groupId = "order-service-group")
    public void consumeSavedOrder(OrderEvent orderEvent, Acknowledgment acknowledgment){
        List<StockProduct> stockProducts= stockProductsService.listStockProductsByAllId(orderEvent.getItems().stream().map(ItemDto::getStockProductId).toList());
        Map<Long,Integer> productsMap=orderEvent.getItems().stream()
                .collect(Collectors.toMap(ItemDto::getStockProductId,ItemDto::getQuantity));
        try {
            for(StockProduct stockProduct: stockProducts){
                Integer requestedQuantity=productsMap.get(stockProduct.getStockProductId());
                if (stockProduct.getQuantity()<requestedQuantity){
                    throw new StockOutOfRequiredQuantityException("stock is out of the required quantity for the "+ stockProduct.getStockProductId());
                }
                stockProduct.setQuantity(stockProduct.getQuantity()-requestedQuantity);
            }
        }catch (StockOutOfRequiredQuantityException stockOutOfRequiredQuantityException){
            kafkaStockReservedFailedProducer.sendStockReservedFailedEvent(StockReservedFailedEvent.builder()
                    .orderId(orderEvent.getOrderId())
                    .event("stock-reserved-failed")
                    .date(LocalDateTime.now())
                    .message(stockOutOfRequiredQuantityException.getMessage())
                    .build());
        }
        stockProductsService.saveAllProducts(stockProducts);
        kafkaStockReservedProducer.sendReducedProductEvent(ReducedProductsEvent.builder()
                .orderId(orderEvent.getOrderId())
                .items(stockProducts.stream().map(stockProduct -> ItemDto.builder()
                        .stockProductId(stockProduct.getStockProductId())
                        .quantity(stockProduct.getQuantity())
                        .unitPrice(stockProduct.getUnitPrice())
                        .discountPercentage(stockProduct.getDiscountPercentage()).build()).toList())
                .event("stock-reserved")
                .build());
        acknowledgment.acknowledge();
    }
}
