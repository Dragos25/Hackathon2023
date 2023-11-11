package com.example.hackathon2023.model.YahooFinance;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
@Data

public class Quote{
    public ArrayList<Integer> volume;
    public ArrayList<Double> close;
    public ArrayList<Double> high;
    @JsonProperty("open")
    public ArrayList<Double> myopen;
    public ArrayList<Double> low;
}
