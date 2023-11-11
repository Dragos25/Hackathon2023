package com.example.hackathon2023.model.YahooFinance;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class YahooRequest {
    String symbol;
    Long period1;
    Long period2;
    String interval;
}
