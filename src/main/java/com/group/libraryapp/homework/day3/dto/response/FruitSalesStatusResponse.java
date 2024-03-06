package com.group.libraryapp.homework.day3.dto.response;

public class FruitSalesStatusResponse {
    private long salesAmount;
    private long notSalesAmount;

    public long getSalesAmount() {
        return salesAmount;
    }

    public long getNotSalesAmount() {
        return notSalesAmount;
    }

    public FruitSalesStatusResponse(long salesAmount, long notSalesAmount) {
        this.salesAmount = salesAmount;
        this.notSalesAmount = notSalesAmount;
    }
}
