package com.group.libraryapp.homework.day3.service;

import com.group.libraryapp.homework.day3.dto.request.FruitCreateRequest;
import com.group.libraryapp.homework.day3.dto.response.FruitSalesStatusResponse;
import com.group.libraryapp.homework.day3.repository.FruitRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class FruitService {

    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public void saveFruit(@RequestBody FruitCreateRequest request) {
        fruitRepository.saveFruit(request);
    }

    public void saveSoldFruit(@RequestBody FruitCreateRequest request) {
        fruitRepository.saveSoldFruit(request);
    }

    public FruitSalesStatusResponse readFruitStatus(@RequestParam String name) {
       return fruitRepository.readFruitStatus(name);
    }
}
