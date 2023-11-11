package com.example.hackathon2023.Controller;

import com.example.hackathon2023.Service.VeridionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

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

}