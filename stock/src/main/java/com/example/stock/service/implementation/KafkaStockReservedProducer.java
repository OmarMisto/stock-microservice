package com.example.stock.service.implementation;

import com.example.stock.model.dto.ReducedProductsEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaStockReservedProducer {
    private final String topic="stock-reserved";
    @Autowired
    private KafkaTemplate<String, ReducedProductsEvent>kafkaTemplate;
    public void sendReducedProductEvent(ReducedProductsEvent reducedProductEvent){
        kafkaTemplate.send(topic,""+reducedProductEvent.getOrderId(),reducedProductEvent);
    }

}
