package com.example.currency_converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyUtil currencyUtil; // Kotlin class

    public double convert(String from, String to, double amount) {
        return currencyUtil.calculateConversion(from, to, amount);
    }
}
