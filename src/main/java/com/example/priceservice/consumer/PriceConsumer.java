package com.example.priceservice.consumer;

import com.example.priceservice.consumer.dto.PriceRequest;
import com.example.priceservice.consumer.dto.PriceResponse;
import com.example.priceservice.service.PriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class PriceConsumer {

    @Autowired
    private final PriceService priceService = new PriceService();

    @RabbitListener(queues = "price_queue")
    public PriceResponse calculatePrice(PriceRequest priceRequest){
        return priceService.sumOfALlValues(priceRequest);
    }

}
