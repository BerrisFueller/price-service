package com.example.priceservice.consumer;

import com.example.priceservice.consumer.dto.PriceRequest;
import com.example.priceservice.consumer.dto.PriceResponse;
import com.example.priceservice.service.PriceService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;

@Slf4j
public class PriceConsumer {

    @Autowired
    private final PriceService priceService = new PriceService();

    @RabbitListener(queues = "price_queue")
    public String calculatePrice(Message message){
        PriceRequest priceRequest = new Gson().fromJson(new String(message.getBody(), StandardCharsets.UTF_8), PriceRequest.class);

        PriceResponse response = priceService.sumOfALlValues(priceRequest);

        return new Gson().toJson(response);
    }

}
