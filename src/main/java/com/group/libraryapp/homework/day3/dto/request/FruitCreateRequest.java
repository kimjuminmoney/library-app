package com.group.libraryapp.homework.day3.dto.request;

import java.time.LocalDate;

public class FruitCreateRequest {
    private Long id;

    public Long getId() {
        return id;
    }

    private String name;
    private LocalDate warehousingDate;
    private long price;

    public String getName() {
        return name;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }

    public long getPrice() {
        return price;
    }
}
