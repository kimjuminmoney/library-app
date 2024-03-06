package com.group.libraryapp.homework.day3.controller;

import com.group.libraryapp.homework.day3.dto.request.FruitCreateRequest;
import com.group.libraryapp.homework.day3.dto.response.FruitCountResponse;
import com.group.libraryapp.homework.day3.dto.response.FruitSalesStatusResponse;
import com.group.libraryapp.homework.day3.dto.response.FruitUnSoldOption;
import com.group.libraryapp.homework.day3.service.FruitJpaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FruitController {
    private final FruitJpaService fruitService;

    public FruitController(FruitJpaService fruitService) {
        this.fruitService = fruitService;
    }

    @PostMapping("/api/v1/fruit")
    public void saveFruit(@RequestBody FruitCreateRequest request) {
        fruitService.saveFruit(request);

    }

    @PutMapping("/api/v1/fruit")
    public void saveSoldFruit(@RequestBody FruitCreateRequest request) {
        fruitService.saveSoldFruit(request);
    }

    @GetMapping("/api/v1/fruit/stat")
    public FruitSalesStatusResponse readFruitStatus(@RequestParam String name) {
        return fruitService.readFruitStatus(name);
    }

    @GetMapping("/api/v1/fruit/count")
    public FruitCountResponse readCountByName(@RequestParam String name) {
        return fruitService.readCountByName(name);
    }

    @GetMapping("api/v1/fruit/list")
    public List<FruitUnSoldOption> readUnSold(@RequestParam String option, @RequestParam int price){
        return fruitService.readUnSold(option, price);
    }

}
