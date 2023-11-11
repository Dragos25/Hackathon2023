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

import java.util.List;

import static reactor.core.publisher.Mono.just;

@Service
@RequiredArgsConstructor
public class SymbolService {
    public Mono<DataClass> getSymbols() {
        return SymbolClient.getResponse();
    }

    public static Mono<String> fullNameToSymbol(List<String> fullnames) {
        DataClass allList = SingletonDataClass.get();
        for (String fullname : fullnames) {
            for (SymbolsRequest symbolsRequest : allList.getSymbolsRequests()) {
                for (Quotes quotes : symbolsRequest.getQuotes())
                    if (quotes.getLongName().equals(fullname))
                        return just(quotes.getSymbol());
            }
        }
        return Mono.empty();
    }

}
