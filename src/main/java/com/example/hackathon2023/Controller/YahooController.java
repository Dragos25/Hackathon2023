package com.example.hackathon2023.Controller;

import com.example.hackathon2023.Service.SymbolService;
import com.example.hackathon2023.Service.YahooFinanceService;
import com.example.hackathon2023.model.YahooFinance.YahooFinanceObject;
import com.example.hackathon2023.model.YahooFinance.YahooRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/yahoo")
@RequiredArgsConstructor
public class YahooController {
    @Autowired
    YahooFinanceService yahooFinanceService;
    @Autowired
    SymbolService symbolService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public Mono<YahooFinanceObject> getYahooData(@RequestBody YahooRequest yahooRequest) {
        List<String> fullname = yahooRequest.getFullName();
        Mono<String> symbol = symbolService.fullNameToSymbol(fullname);
//        return symbol.flatMap(
//                p->{
//                    yahooRequest.setFullName(p);
        return yahooFinanceService.getYahooFinanceResponse(yahooRequest, symbol.block());
    }
}

