package com.example.baitap2.controller;

import com.example.baitap2.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorService calculatorService;
    @RequestMapping("/")
    public String index() {
        return "index";
    }
    @RequestMapping("/calculate")
    public String calculate(
            @RequestParam("number1") double number1,
            @RequestParam("number2") double number2,
            @RequestParam("operation") String operation,
            Model model) {
        try {
            double result = calculatorService.calculate(number1, number2, operation);
            model.addAttribute("result", result);
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
        }
        return "index";
    }
}
