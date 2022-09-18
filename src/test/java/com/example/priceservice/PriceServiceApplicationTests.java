package com.example.priceservice;

import com.example.priceservice.service.PriceService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PriceServiceApplicationTests {

    private final PriceService priceService = new PriceService();
    private final List<Integer> priceList = Arrays.asList(12,18,20,15,19,21);



    @Test
    void testPriceSum() {
        assertEquals( priceService.sumOfALlValues(priceList),105);
    }



}
