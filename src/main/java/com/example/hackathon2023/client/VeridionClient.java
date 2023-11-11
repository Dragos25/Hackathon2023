package com.example.hackathon2023.client;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class VeridionClient {
    public static WebClient client = WebClient.create("https://data.veridion.com/search/v2/companies");
    public static Mono<Object> getResponse(Object request){
        System.out.println(request);
        WebClient.ResponseSpec responseSpec = client.get()
                .uri("http://example.com")
                .retrieve();
        Mono<Object> mono =  responseSpec.bodyToMono(Object.class);
        return mono;
    }
}
