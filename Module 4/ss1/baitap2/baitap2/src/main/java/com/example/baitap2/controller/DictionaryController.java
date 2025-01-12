package com.example.baitap2.controller;

import com.example.baitap2.service.impl.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;
    @GetMapping("/")
    public String home() {
        return "index";
    }
    @GetMapping("/translate")
    public String translate(@RequestParam("word") String word, Model model) {
        String meaning = dictionaryService.translateWord(word);
        if (meaning != null) {
            model.addAttribute("word", word);
            model.addAttribute("meaning", meaning);
        } else {
            model.addAttribute("message", "Không tìm thấy từ.");
        }
        return "result";
    }
}
