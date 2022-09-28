package com.example.priceservice;

import com.example.priceservice.consumer.dto.PriceRequest;
import com.example.priceservice.consumer.dto.PriceResponse;
import com.example.priceservice.service.PriceService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PriceServiceApplicationTests {
            private final PriceService priceService = new PriceService();


            @Test
            public void CalculatePrice(){
                List<BigDecimal> list = new ArrayList<>();
                list.add(BigDecimal.valueOf(10));
                list.add(BigDecimal.valueOf(20));
                list.add(BigDecimal.valueOf(30));
                list.add(BigDecimal.valueOf(20));
                list.add(BigDecimal.valueOf(20));
                list.add(BigDecimal.valueOf(20));
                list.add(BigDecimal.valueOf(20));
                list.add(BigDecimal.valueOf(20));

                PriceRequest priceRequest = new PriceRequest();
                priceRequest.setPriceList(list);


                PriceResponse priceResponse = priceService.sumOfALlValues(priceRequest);

                assertEquals(BigDecimal.valueOf(160).setScale(2, RoundingMode.CEILING),priceResponse.getPrice());
            }


            @Test
            public void CalculateNegativePrice(){
                List<BigDecimal> list = new ArrayList<>();
                list.add(BigDecimal.valueOf(-10));
                list.add(BigDecimal.valueOf(-20));
                list.add(BigDecimal.valueOf(-30));
                list.add(BigDecimal.valueOf(20));
                list.add(BigDecimal.valueOf(20));
                list.add(BigDecimal.valueOf(20));
                list.add(BigDecimal.valueOf(20));
                list.add(BigDecimal.valueOf(20));

                PriceRequest priceRequest = new PriceRequest();
                priceRequest.setPriceList(list);


                PriceResponse priceResponse = priceService.sumOfALlValues(priceRequest);

                assertEquals(BigDecimal.valueOf(40).setScale(2, RoundingMode.CEILING),priceResponse.getPrice());
            }




    @Test
    public void CalculatePriceOverflow(){
        List<BigDecimal> list = new ArrayList<>();
        list.add(BigDecimal.valueOf(Double.MAX_VALUE));
        list.add(BigDecimal.valueOf(Double.MAX_VALUE));


        PriceRequest priceRequest = new PriceRequest();
        priceRequest.setPriceList(list);


        PriceResponse priceResponse = priceService.sumOfALlValues(priceRequest);

        assertEquals(BigDecimal.valueOf(Double.MAX_VALUE).add(BigDecimal.valueOf(Double.MAX_VALUE)).setScale(2, RoundingMode.CEILING),priceResponse.getPrice());
    }
}
