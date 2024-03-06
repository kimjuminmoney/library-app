package com.group.libraryapp.homework.day2.dto.response;

import com.group.libraryapp.homework.day2.dto.request.NumbersRequest;

import java.util.List;

public class NumbersResponse {
    private int sum;

    public int getSum() {
        return sum;
    }

    public NumbersResponse(NumbersRequest num) {
        List<Integer> numbers = num.getNumbers();
        for( int i : numbers){
            sum += i;
        }
        this.sum = sum;
    }
}
