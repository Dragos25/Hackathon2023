package com.example.hackathon2023.Service;

import com.example.hackathon2023.client.SymbolClient;
import com.example.hackathon2023.model.Symbols.DataClass;
import com.example.hackathon2023.model.Symbols.Quotes;
import com.example.hackathon2023.model.Symbols.SingletonDataClass;
import com.example.hackathon2023.model.Symbols.SymbolsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.swing.plaf.synth.SynthButtonUI;

import static reactor.core.publisher.Mono.just;

@Service
@RequiredArgsConstructor
public class SymbolService {
    public Mono<DataClass> getSymbols(){
        return SymbolClient.getResponse();
    }
    public static Mono<String> fullNameToSymbol(String fullname){
        DataClass allList = SingletonDataClass.get();
        for(SymbolsRequest symbolsRequest: allList.getSymbolsRequests()){
            for(Quotes quotes:symbolsRequest.getQuotes())
                if(quotes.getLongName().equals(fullname))
                    return just(quotes.getSymbol());
        }
       return Mono.empty();
    }
}
