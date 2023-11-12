package com.example.hackathon2023.Service;

import com.example.hackathon2023.client.VeridionClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VeridionService {
    List<String> baseWordsAscending = List.of("machine-learning", "java", "ai", "cybersecurity", "plesk", "plm", "python", "blockchain", "pdf", "data", "artificial intelligence", "Intelligence");
    List<String> baseWordsDescending = List.of("fullstack","web-based" , ".net", "educational-tech", "tech-bubble", "cybersecurity",
            "social-media", "domain-hosting", "search-engine", "accessibility solutions",
            "music industry", "traditional-gaming", "app-innovation",  "blogging", "multi-function");
    List<String> baseWordsEmerging = List.of("");
    public Mono<Object> getTest(Object object){
        return VeridionClient.getResponse(object);
    }

    public String getKeywords(ArrayList<String> keywords) {
        List<String> matchingGood = new ArrayList<>();
        for (String keyword : keywords) {
            for(String goodWord:baseWordsAscending)
                if (keyword.toLowerCase().contains(goodWord))
                 matchingGood.add(keyword);
        }
        List<String> matchingBad = new ArrayList<>();
        for (String keyword : keywords) {
            for(String badWord:baseWordsDescending)
                if (keyword.toLowerCase().contains(badWord))
                 matchingBad.add(keyword);
        }
/*        List<String> matchingEmerging = new ArrayList<>();
        for (String keyword : keywords) {
            for(String emergingWord:baseWordsEmerging)
                if (keyword.toLowerCase().contains(emergingWord))
                    matchingEmerging.add(keyword.toLowerCase());
        }*/

        String output = "";
        if (matchingGood.size() > 0) {
            output += "This company has the following ascending trends: ";
            for (String word : matchingGood) {
                output += word + " ";
            }
        }
        output += '\n';

        if (matchingBad.size() > 0) {
            output += "This company has the following descending trends: ";
            for (String word : matchingBad) {
                output += word + " ";
            }
        }
        output += '\n';
/*
        if (matchingEmerging.size() > 0) {
            output += "Matching emerging trends found for this comapny, ex: ";
            for (String word : matchingBad) {
                output += word + " ";
            }
        }*/


        return output;
    }
}
