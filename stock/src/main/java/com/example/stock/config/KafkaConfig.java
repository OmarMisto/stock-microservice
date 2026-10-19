package com.example.stock.config;

import com.example.stock.model.dto.OrderEvent;
import com.example.stock.service.exception.StockOutOfRequiredQuantityException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.CommonErrorHandler;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.util.backoff.FixedBackOff;

@Configuration
public class KafkaConfig {
    @Bean
    public CommonErrorHandler errorHandler(KafkaTemplate<String, OrderEvent> kafkaTemplate){
        DeadLetterPublishingRecoverer recoverer= new DeadLetterPublishingRecoverer(kafkaTemplate);
        FixedBackOff backOff= new FixedBackOff(1000,3 );
        DefaultErrorHandler errorHandler= new DefaultErrorHandler(recoverer,backOff);
        errorHandler.addNotRetryableExceptions(StockOutOfRequiredQuantityException.class);
        return errorHandler;
    }
}
