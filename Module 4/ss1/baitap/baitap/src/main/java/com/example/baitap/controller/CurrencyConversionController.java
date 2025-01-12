package com.example.baitap.controller;

import com.example.baitap.service.impl.CurrencyConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConversionController {
    @Autowired
    private CurrencyConversionService conversionService;
    @RequestMapping("/convert")
    public String convert(@RequestParam("rate") String rateInput,
                          @RequestParam("usd") String usdInput,
                          Model model) {
        try {
            double rate = Double.parseDouble(rateInput);
            double usd = Double.parseDouble(usdInput);
            if (rate <= 0 || usd <= 0) {
                model.addAttribute("error", "Tỉ giá và số tiền USD phải lớn hơn 0.");
                return "index";
            }
            double vnd = conversionService.convert(rate, usd);
            model.addAttribute("rate", rate);
            model.addAttribute("usd", usd);
            model.addAttribute("vnd", vnd);
            return "result";
        } catch (NumberFormatException e) {
            model.addAttribute("error", "Lỗi.");
            return "index";
        }
    }
    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
