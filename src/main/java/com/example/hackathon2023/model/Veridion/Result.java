package com.example.hackathon2023.model.Veridion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result{
    public String soleadify_id;
    public String company_name;
    public ArrayList<String> company_legal_names;
    public ArrayList<String> company_commercial_names;
    public String main_country_code;
    public String main_country;
    public String main_region;
    public String main_city;
    public String main_street;
    public String main_street_number;
    public String main_postcode;
    public double main_latitude;
    public double main_longitude;
    public ArrayList<Location> locations;
    public int num_locations;
    public String company_type;
    public int year_founded;
    public int employee_count;
    public Object estimated_revenue;
    public String short_description;
    public String long_description;
    public ArrayList<String> business_tags;
    public String main_business_category;
    public String main_industry;
    public String main_sector;
    public String primary_phone;
    public ArrayList<String> phone_numbers;
    public String primary_email;
    public ArrayList<String> emails;
    public ArrayList<String> other_emails;
    public String website_url;
    public String website_domain;
    public String website_tld;
    public String website_language_code;
    public String facebook_url;
    public String twitter_url;
    public String instagram_url;
    public String linkedin_url;
    public String ios_app_url;
    public String android_app_url;
    public String youtube_url;
    public String cms;
    public int alexa_rank;
    public ArrayList<String> technologies;
    public Naics2022 naics_2022;
    public ArrayList<NaceRev2> nace_rev2;
    public ArrayList<String> ncci_codes_28_1;
    public ArrayList<Sic> sic;
    public ArrayList<IsicV4> isic_v4;
    public SicsIndustry sics_industry;
    public SicsSubsector sics_subsector;
    public SicsSector sics_sector;
    public ArrayList<IbcInsurance> ibc_insurance;
    public Date created_at;
    public Date last_updated_at;
}
