package com.group.libraryapp.homework.day3.service;

import com.group.libraryapp.homework.day3.domain.Fruit;
import com.group.libraryapp.homework.day3.domain.FruitJpaRepository;
import com.group.libraryapp.homework.day3.dto.request.FruitCreateRequest;
import com.group.libraryapp.homework.day3.dto.response.FruitCountResponse;
import com.group.libraryapp.homework.day3.dto.response.FruitSalesStatusResponse;
import com.group.libraryapp.homework.day3.dto.response.FruitUnSoldOption;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class FruitJpaService {

    private final FruitJpaRepository fruitJpaRepository;

    public FruitJpaService(FruitJpaRepository fruitJpaRepository) {
        this.fruitJpaRepository = fruitJpaRepository;
    }


    public void saveFruit(FruitCreateRequest request) {
        fruitJpaRepository.save(new Fruit(request.getName(), request.getPrice(), request.getWarehousingDate()));
    }

    public void saveSoldFruit(FruitCreateRequest request) {
        Fruit fruit = fruitJpaRepository.findById(request.getId())
                .orElseThrow(IllegalAccessError::new);
        fruit.setSold(true);
        fruitJpaRepository.save(fruit);
    }

    public FruitSalesStatusResponse readFruitStatus(String name) {
        Long salesAmount = fruitJpaRepository.findByNameAndIsSold(name, true)
                .stream().mapToLong(fruits -> fruits.getPrice()).sum();
        Long notSalesAmount = fruitJpaRepository.findByNameAndIsSold(name, false)
                .stream().mapToLong(fruits -> fruits.getPrice()).sum();
        return new FruitSalesStatusResponse(salesAmount,notSalesAmount);
    }

    public FruitCountResponse readCountByName(String name){
        return new FruitCountResponse(fruitJpaRepository.countByName(name));
    }

    public List<FruitUnSoldOption> readUnSold(@RequestParam String option,int price){
        if (!"GTE".equals(option)&&!"LTE".equals(option)){
            throw new IllegalArgumentException("Invalid option");
        }
        List<FruitUnSoldOption> fuso = null;
        if ("GTE".equals(option)){
            fuso = fruitJpaRepository.findByPriceGreaterThanEqualAndIsSold(price, false);
        }
        if("LTE".equals(option)){
            fuso = fruitJpaRepository.findByPriceLessThanEqualAndIsSold(price, false);
        }
        return fuso;
    }
}
