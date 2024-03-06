package com.group.libraryapp.homework.day2.dto.request;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class DayofTheWeekRequest {
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public DayofTheWeekRequest(LocalDate date) {
        this.date = date;
    }
}
