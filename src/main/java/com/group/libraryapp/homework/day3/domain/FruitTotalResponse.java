package com.group.libraryapp.homework.day3.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

public class FruitTotalResponse {

    private Long total;

    private boolean isSold;

    public Long getTotal() {
        return total;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    public FruitTotalResponse() {
    }

    public FruitTotalResponse(Long total, boolean isSold) {
        this.total = total;
        this.isSold = isSold;
    }
}
