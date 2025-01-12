package com.example.baitap2.service.impl;

import com.example.baitap2.repository.DictionaryRepository;
import com.example.baitap2.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryService implements IDictionaryService {

    @Autowired
    private DictionaryRepository dictionaryRepository;
    @Override
    public String translateWord(String word) {
        return dictionaryRepository.findMeaning(word);
    }
}
