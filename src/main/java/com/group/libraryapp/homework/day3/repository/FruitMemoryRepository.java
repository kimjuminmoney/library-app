package com.group.libraryapp.homework.day3.repository;

import com.group.libraryapp.homework.day3.dto.request.FruitCreateRequest;
import com.group.libraryapp.homework.day3.dto.response.FruitSalesStatusResponse;
import org.springframework.stereotype.Repository;

@Repository
public class FruitMemoryRepository implements FruitRepository{
    @Override
    public void saveFruit(FruitCreateRequest request) {

    }

    @Override
    public void saveSoldFruit(FruitCreateRequest request) {

    }

    @Override
    public FruitSalesStatusResponse readFruitStatus(String name) {
        return null;
    }
}
