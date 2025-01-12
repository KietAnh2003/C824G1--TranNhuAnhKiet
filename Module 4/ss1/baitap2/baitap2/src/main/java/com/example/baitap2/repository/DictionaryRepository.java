package com.example.baitap2.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepository {
    private static final Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("hello", "xin chào");
        dictionary.put("world", "thế giới");
        dictionary.put("red", "màu đỏ");
        dictionary.put("book", "quyển sách");
    }
    public String findMeaning(String word) {
        return dictionary.get(word.toLowerCase());
    }
}
