package com.example.priceservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "price")
public class CalculatorController {

    @GetMapping(path = "{priceA}/{priceB}")
    public double addPrices(@PathVariable double priceA, @PathVariable double priceB) {

        Calculator calculate = new Calculator();

        return calculate.add(priceA, priceB);

    }

    @GetMapping(path = "{priceList}")
    public double sumPriceList(@PathVariable List<Double> priceList) {

        Calculator calculate = new Calculator();

        return calculate.sumList(priceList);

    }

}
