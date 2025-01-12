package com.example.baitap2.service.impl;

import com.example.baitap2.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {
    @Override
    public double calculate(double number1, double number2, String operation) {
        switch (operation) {
            case "add":
                return number1 + number2;
            case "subtract":
                return number1 - number2;
            case "multiply":
                return number1 * number2;
            case "divide":
                if (number2 == 0) {
                    throw new RuntimeException("Cant divide by 0!");
                }
                return number1 / number2;
            default:
                throw new RuntimeException("Invalid operation!");
        }
    }
}
