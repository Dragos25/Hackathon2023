package com.example.hackathon2023.Controller;

import com.example.hackathon2023.Service.SymbolService;
import com.example.hackathon2023.model.Symbols.DataClass;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/symbols")
public class SymbolController {
    @Autowired
    SymbolService symbolService;

    @GetMapping()
    public Mono<DataClass> getSymbols(){
        return symbolService.getSymbols();
    }

    @GetMapping("/convert")
    public Mono<String> fullNameToSymbol(@RequestParam List<String> fullName){
        return SymbolService.fullNameToSymbol(fullName);

    }
}
