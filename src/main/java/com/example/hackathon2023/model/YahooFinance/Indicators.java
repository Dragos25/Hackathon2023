package com.example.hackathon2023.model.YahooFinance;

import lombok.Data;

import java.util.ArrayList;
@Data
public class Indicators{
    public ArrayList<Quote> quote;
    public ArrayList<Adjclose> adjclose;
}
