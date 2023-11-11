
package com.example.hackathon2023.model.YahooFinance;

import lombok.Data;

import java.util.ArrayList;
@Data

public class Result{
    public Meta meta;
    public ArrayList<Integer> timestamp;
    public Indicators indicators;
}
