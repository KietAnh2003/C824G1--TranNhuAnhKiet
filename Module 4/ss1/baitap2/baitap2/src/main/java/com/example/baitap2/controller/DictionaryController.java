package com.example.baitap2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    private static final Map<String, String> DICTIONARY = new HashMap<>();

    static {
        DICTIONARY.put("hello", "xin chào");
        DICTIONARY.put("world", "thế giới");
        DICTIONARY.put("spring", "mùa xuân");
        DICTIONARY.put("java", "ngôn ngữ lập trình Java");
    }
    @GetMapping("/")
    public String home() {
        return "index";
    }
    @GetMapping("/translate")
    public String translate(@RequestParam("word") String word, Model model) {
        String meaning = DICTIONARY.get(word.toLowerCase());
        if (meaning != null) {
            model.addAttribute("word", word);
            model.addAttribute("meaning", meaning);
        } else {
            model.addAttribute("message", "Không tìm thấy từ này trong từ điển.");
        }
        return "result";
    }
}