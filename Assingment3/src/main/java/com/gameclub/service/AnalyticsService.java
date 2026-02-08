package com.gameclub.service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

public class AnalyticsService {

    public void printTopRates(List<BigDecimal> rates) {
        rates.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .forEach(System.out::println);
    }
}
