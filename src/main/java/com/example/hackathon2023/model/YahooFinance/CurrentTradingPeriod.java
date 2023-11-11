package com.example.hackathon2023.model.YahooFinance;

import lombok.Data;

@Data
public class CurrentTradingPeriod{
    public Pre pre;
    public Regular regular;
    public Post post;
}
