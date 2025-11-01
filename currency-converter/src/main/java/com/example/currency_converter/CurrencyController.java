package com.example.currency_converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convert")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping
    public ResponseEntity<Double> convertCurrency(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam double amount) {
        double result = currencyService.convert(from, to, amount);
        return ResponseEntity.ok(result);
    }
}
