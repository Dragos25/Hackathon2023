package com.example.hackathon2023.Controller;

import com.example.hackathon2023.Json;
import com.example.hackathon2023.Service.VeridionService;
import com.example.hackathon2023.model.Keywords;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.security.Key;
import java.util.ArrayList;

@RestController
@RequestMapping("/veridion")
@RequiredArgsConstructor
public class VeridionController {
    @Autowired
    VeridionService service;
    @GetMapping("/")
    public Mono<Object> testEndpoint(@RequestBody Object object){
        return service.getTest(object);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/keywords")
    public Json keywords(@RequestBody Keywords keywords){
        return new Json(service.getKeywords(keywords.getBusiness_tags()));
    }
}