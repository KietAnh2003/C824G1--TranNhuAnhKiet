package com.example.baitap1.controller;

import com.example.baitap1.service.impl.CondimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller

public class SanwichController {
    @Autowired
    private CondimentService condimentService;
    @RequestMapping("/")
    public String save(@RequestParam(value = "condiment", required = false) String[] condiment,
                       @RequestParam(value = "action", required = false) String action,
                       Model model) {
        // kiểm tra không chọn checkbox mà ấn SAVE
        if ("save".equals(action)) {
            if (condiment == null || condiment.length == 0) {
                model.addAttribute("error", "Please select condiments !");
            } else if (!condimentService.validateCondiments(condiment)) {
                model.addAttribute("error", "Invalid condiments");
            } else {
                model.addAttribute("condiment", condiment);
            }
        }
        return "index";
    }
}
