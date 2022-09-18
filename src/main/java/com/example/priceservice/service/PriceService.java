package com.example.priceservice.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {


    public int sumOfALlValues(List<Integer> pirceList){
        return pirceList.stream().reduce(0, Integer::sum);
    }

}