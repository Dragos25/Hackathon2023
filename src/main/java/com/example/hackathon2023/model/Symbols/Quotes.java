package com.example.hackathon2023.model.Symbols;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quotes {
    String symbol;
    String shortName;
    String longName;
    String exchange;
    String market;
    String quoteType;
}
