package com.example.priceservice;

import java.util.List;

public class Calculator {

    public Calculator() {
    }

    public double add(double a, double b) {
        return a + b;
    }

    public double sumList(List<Double> priceList) {
        double sum = 0;
        for (int i = 0; i < priceList.size(); i++) {
            sum = sum + priceList.get(i);
        }
        double round = Math.round(100 * sum);
        return round / 100;
    }

}
