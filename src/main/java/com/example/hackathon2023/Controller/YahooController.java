package com.example.hackathon2023.Controller;

import com.example.hackathon2023.Service.YahooFinanceService;
import com.example.hackathon2023.model.YahooFinance.YahooFinanceObject;
import com.example.hackathon2023.model.YahooFinance.YahooRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/yahoo")
@RequiredArgsConstructor
public class YahooController {
    @Autowired
    YahooFinanceService yahooFinanceService;
    @GetMapping
    public Mono<YahooFinanceObject> getYahooData(@RequestBody YahooRequest yahooRequest){
        return yahooFinanceService.getYahooFinanceResponse(yahooRequest);
    }
}
