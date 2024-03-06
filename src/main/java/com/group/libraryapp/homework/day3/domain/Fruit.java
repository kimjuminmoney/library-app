package com.group.libraryapp.homework.day3.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long price;
    @Column(name = "is_sold")
    private boolean isSold = false;

    @Column(name = "warehousingdate")
    private LocalDate warehousingDate;

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }

    public void setSold(boolean sold) {
        this.isSold = sold;
    }

    public Fruit(String name, Long price, LocalDate warehousingDate) {
        this.name = name;
        this.price = price;
        this.warehousingDate = warehousingDate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getPrice() {
        return price;
    }

    public boolean isSold() {
        return isSold;
    }

    public Fruit() {
    }
}
