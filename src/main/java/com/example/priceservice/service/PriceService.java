package com.example.priceservice.service;

import com.example.priceservice.consumer.dto.PriceRequest;
import com.example.priceservice.consumer.dto.PriceResponse;
import org.springframework.stereotype.Service;

@Service
public class PriceService {


    public PriceResponse sumOfALlValues(PriceRequest priceRequest){
        return new PriceResponse().setSumOfAllPrices(priceRequest.getPriceList().stream().reduce(0, Integer::sum));
    }

}