package com.example.priceservice.service;

import com.example.priceservice.consumer.dto.PriceRequest;
import com.example.priceservice.consumer.dto.PriceResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PriceService {


    public PriceResponse sumOfALlValues(PriceRequest priceRequest){

        return new PriceResponse().setTotalPrice(priceRequest.getPriceList().stream().reduce(BigDecimal.ZERO, BigDecimal::add));
    }

}