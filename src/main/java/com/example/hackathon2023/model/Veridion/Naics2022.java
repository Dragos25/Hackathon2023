package com.example.hackathon2023.model.Veridion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Naics2022{
    public Primary primary;
    public ArrayList<Secondary> secondary;
}
