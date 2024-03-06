package com.group.libraryapp.homework.day5;

public class Number {
    private int number;
    private int count;

    public int getNumber() {
        return number;
    }

    public int getCount() {
        return ++count;
    }

    public Number(int number, int count) {
        this.number = number;
        this.count = count;
    }
}
