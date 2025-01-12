package com.example.baitap.service.impl;

import com.example.baitap.service.ICurrencyConversionService;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConversionService implements ICurrencyConversionService {
    @Override
    public double convert(double rate, double usd) {
        return rate * usd;
    }
}
