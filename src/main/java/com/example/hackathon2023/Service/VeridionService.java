package com.example.hackathon2023.Service;

import com.example.hackathon2023.client.VeridionClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class VeridionService {
    public Mono<Object> getTest(Object object){
        return VeridionClient.getResponse(object);
    }
}
