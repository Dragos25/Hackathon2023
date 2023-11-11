package com.example.hackathon2023.Service;

import com.example.hackathon2023.client.YahooClient;
import com.example.hackathon2023.model.YahooFinance.YahooFinanceObject;
import com.example.hackathon2023.model.YahooFinance.YahooRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class YahooFinanceService {
    //YahooClient yahooClient;
    public Mono<YahooFinanceObject> getYahooFinanceResponse(YahooRequest yahooRequest){
        return YahooClient.getResponse(
                yahooRequest.getSymbol(),
                yahooRequest.getPeriod1(),
                yahooRequest.getPeriod2(),
                yahooRequest.getInterval());

    }

}
