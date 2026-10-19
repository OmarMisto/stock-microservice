package com.example.stock.service.implementation;

import com.example.stock.model.dto.StockReservedFailedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaStockReservedFailedProducer {
    private final String topic="reserved-failed";
    private final KafkaTemplate<String, StockReservedFailedEvent> kafkaTemplate;
    public void sendStockReservedFailedEvent(StockReservedFailedEvent stockReservedFailedEvent){
        kafkaTemplate.send(topic,""+stockReservedFailedEvent.getOrderId(),stockReservedFailedEvent);
    }
}
