package com.example.hackathon2023.model.Veridion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Root{
    public Pagination pagination;
    public int count;
    public ArrayList<Result> result;
}
