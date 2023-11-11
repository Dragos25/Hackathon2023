package com.example.hackathon2023.model.Symbols;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@NoArgsConstructor

public class SymbolsRequest {
    String market;
    String abbreviation;
    Integer totalCount;
    List<Quotes> quotes;
    String lastUpdated;
}
