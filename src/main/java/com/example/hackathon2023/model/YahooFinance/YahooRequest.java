package com.example.hackathon2023.model.YahooFinance;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class YahooRequest {
    List<String> fullName;
    Long period1;
    Long period2;
    String interval;
}
