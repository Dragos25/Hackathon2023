package com.example.hackathon2023.model.Symbols;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class DataClass {
    @JsonProperty("data")
    ArrayList<SymbolsRequest> symbolsRequests;
}
