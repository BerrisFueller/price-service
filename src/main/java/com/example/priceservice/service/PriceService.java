package com.example.priceservice.service;

import com.example.priceservice.server.DTO.PriceRequest;
import com.example.priceservice.server.DTO.PriceResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {


    public PriceResponse sumOfALlValues(PriceRequest priceRequest){
        return new PriceResponse().setSumOfAllPrices(priceRequest.getPriceList().stream().reduce(0, Integer::sum));
    }

}