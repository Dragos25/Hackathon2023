package com.example.hackathon2023.model.YahooFinance;

import lombok.Data;

import java.util.ArrayList;
@Data

public class Meta{
    public String currency;
    public String symbol;
    public String exchangeName;
    public String instrumentType;
    public int firstTradeDate;
    public int regularMarketTime;
    public int gmtoffset;
    public String timezone;
    public String exchangeTimezoneName;
    public double regularMarketPrice;
    public double chartPreviousClose;
    public int priceHint;
    public CurrentTradingPeriod currentTradingPeriod;
    public String dataGranularity;
    public String range;
    public ArrayList<String> validRanges;
}
