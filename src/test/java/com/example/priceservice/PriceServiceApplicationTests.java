package com.example.priceservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PriceServiceApplicationTests {

    @Test
    void testPriceSum1() {
        Calculator test1 = new Calculator();
        List<Double> priceList = List.of(1412.0);
        assertEquals(1412.0, test1.sumList(priceList));
    }

    @Test
    void testPriceSum2() {
        Calculator test2 = new Calculator();
        List<Double> priceList = List.of(9.0, 10.6);
        assertEquals(19.6, test2.sumList(priceList));
    }

    @Test
    void testPriceSum3() {
        Calculator test3 = new Calculator();
        List<Double> priceList = List.of(78.57, 27.54, 12.25);
        assertEquals(118.36, test3.sumList(priceList));
    }

    @Test
    void testDecimalPlaces() {
        Calculator testDecimals = new Calculator();
        List<Double> priceList = List.of(0.5882, 0.182, 0.160034536137);
        assertEquals(0.93, testDecimals.sumList(priceList));
    }

}
