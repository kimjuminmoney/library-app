package com.group.libraryapp.homework.day2.controller;

import com.group.libraryapp.homework.day2.dto.request.CalculatorRequest;
import com.group.libraryapp.homework.day2.dto.request.DayofTheWeekRequest;
import com.group.libraryapp.homework.day2.dto.request.NumbersRequest;
import com.group.libraryapp.homework.day2.dto.response.CalculatorResponse;
import com.group.libraryapp.homework.day2.dto.response.DayOfTheWeekResponse;
import com.group.libraryapp.homework.day2.dto.response.NumbersResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

@RestController
public class ApiController {

    @GetMapping("/api/v1/calc")
    public CalculatorResponse calc(CalculatorRequest request){
        return new CalculatorResponse(request);
    }

    @GetMapping("/api/v1/day-of-the-week")
    public DayOfTheWeekResponse dayOfWeek(DayofTheWeekRequest request){
        LocalDate date = request.getDate();
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return new DayOfTheWeekResponse(dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.ENGLISH).toUpperCase());
    }

    @PostMapping("/api/v1/numbers")
    public NumbersResponse numbersCalc(@RequestBody NumbersRequest request){
        return new NumbersResponse(request);
    }
}
