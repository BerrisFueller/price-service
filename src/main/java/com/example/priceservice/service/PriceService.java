package com.example.priceservice.service;

import com.example.priceservice.consumer.dto.PriceRequest;
import com.example.priceservice.consumer.dto.PriceResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class PriceService {


    public PriceResponse sumOfALlValues(PriceRequest priceRequest) {
        BigDecimal rawPrice = priceRequest.getPriceList().stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal roundedPrice = rawPrice.setScale(2, RoundingMode.CEILING);

        return new PriceResponse().setPrice(roundedPrice);
    }

}