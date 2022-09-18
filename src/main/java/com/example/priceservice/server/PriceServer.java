package com.example.priceservice.server;

import com.example.priceservice.service.PriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class PriceServer {

    @Autowired
    private final PriceService priceService = new PriceService();

    @RabbitListener(queues = "price_queue")
    public int calculatePrice(List<Integer> priceList){
        return priceService.sumOfALlValues(priceList);
    }

}
