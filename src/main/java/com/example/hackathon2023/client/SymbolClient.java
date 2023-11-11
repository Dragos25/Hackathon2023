package com.example.hackathon2023.client;

import com.example.hackathon2023.model.Symbols.DataClass;
import com.example.hackathon2023.model.YahooFinance.YahooFinanceObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class SymbolClient {
    @Autowired
    public static WebClient client = WebClient.create("https://stock-symbol.herokuapp.com/api/symbols");
    public static Mono<DataClass> getResponse(){

        client  = WebClient.builder()
                .baseUrl("https://stock-symbol.herokuapp.com/api/symbols").exchangeStrategies(ExchangeStrategies.builder()
                        .codecs(configurer -> configurer
                                .defaultCodecs()
                                .maxInMemorySize(16 * 1024 * 1024))

                        .build())
                .build();

        WebClient.ResponseSpec responseSpec = client.
               get()

                .uri(uriBuilder -> uriBuilder
                        .queryParam("market", "us")
                        .build()
                )
                .header("X-API-Key", System.getenv("symbolsApiKey"))
                .retrieve();
        return responseSpec.bodyToMono(DataClass.class);
    }

}
