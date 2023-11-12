package com.example.hackathon2023.model.Veridion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location{
    public String country_code;
    public String country;
    public String region;
    public String city;
    public String postcode;
    public String street;
    public String street_number;
    public double latitude;
    public double longitude;
}
