package com.group.libraryapp.homework.day2.dto.request;

import java.util.List;

public class NumbersRequest {
    private List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public NumbersRequest() {
    }

    public NumbersRequest(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
