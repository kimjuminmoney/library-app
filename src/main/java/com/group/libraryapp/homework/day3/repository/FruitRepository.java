package com.group.libraryapp.homework.day3.repository;

import com.group.libraryapp.homework.day3.dto.request.FruitCreateRequest;
import com.group.libraryapp.homework.day3.dto.response.FruitSalesStatusResponse;

public interface FruitRepository {

    void saveFruit(FruitCreateRequest request);
    void saveSoldFruit(FruitCreateRequest request);
    FruitSalesStatusResponse readFruitStatus( String name);


}
