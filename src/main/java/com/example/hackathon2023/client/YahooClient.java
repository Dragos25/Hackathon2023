package com.example.hackathon2023.client;

import com.example.hackathon2023.model.YahooFinance.YahooFinanceObject;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class YahooClient {
    public static WebClient client = WebClient.create("https://query1.finance.yahoo.com/v8/finance/chart");
    public static Mono<YahooFinanceObject> getResponse(String symbol, Long period1, Long period2, String interval){
        WebClient.ResponseSpec responseSpec = client.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/{symbol}")
                        .queryParam("period1", period1)
                        .queryParam("period2", period2)
                        .queryParam("interval", interval)
                        .build(symbol))

                .retrieve();
        Mono<YahooFinanceObject> mono =  responseSpec.bodyToMono(YahooFinanceObject.class);
        return mono;
    }

}
