package com.example.baitap1.service.impl;

import com.example.baitap1.service.ICondimentService;
import org.springframework.stereotype.Service;

@Service
public class CondimentService implements ICondimentService {
    @Override
    public boolean validateCondiments(String[] condiments) {
        return condiments != null && condiments.length > 0;
    }
}
