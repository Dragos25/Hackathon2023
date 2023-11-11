package com.example.hackathon2023.model.YahooFinance;

import lombok.Data;

import java.util.ArrayList;
@Data
public class Chart{
    public ArrayList<Result> result;
    public Object error;
}
