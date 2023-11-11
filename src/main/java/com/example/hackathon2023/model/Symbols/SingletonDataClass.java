package com.example.hackathon2023.model.Symbols;

import com.example.hackathon2023.client.SymbolClient;

public class SingletonDataClass {
    static DataClass singletonDataClass = SymbolClient.getResponse().block();

    public static DataClass get(){
        return singletonDataClass;
    }
}
