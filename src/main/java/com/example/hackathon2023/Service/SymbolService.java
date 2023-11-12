package com.example.hackathon2023.Service;

import com.example.hackathon2023.client.SymbolClient;
import com.example.hackathon2023.client.YahooClient;
import com.example.hackathon2023.model.Symbols.DataClass;
import com.example.hackathon2023.model.Symbols.Quotes;
import com.example.hackathon2023.model.Symbols.SingletonDataClass;
import com.example.hackathon2023.model.Symbols.SymbolsRequest;
import com.example.hackathon2023.model.YahooFinance.YahooFinanceObject;
import com.example.hackathon2023.model.YahooFinance.YahooRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.swing.plaf.synth.SynthButtonUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    public Mono<Double> calculateScore(YahooRequest yahooRequest) {
        List<Mono<YahooFinanceObject>> list = new ArrayList<>();
        String symbol = fullNameToSymbol(yahooRequest.getFullName()).block();

        YahooFinanceObject financeData = YahooClient.getResponse(symbol, yahooRequest.getPeriod1(), yahooRequest.getPeriod2(), yahooRequest.getInterval()).block();



        // This Mono will be completed with the YahooFinanceObject when the response is received


        // Block the Mono to wait synchronously for the result for this example

        List<Double> closePricesList = financeData.getChart().getResult().get(0).getIndicators().getQuote().get(0).getClose();
        List<Integer> volumesList = financeData.getChart().getResult().get(0).getIndicators().getQuote().get(0).getVolume();

        double[] closePrices = closePricesList.stream().mapToDouble(Double::doubleValue).toArray();
        long[] volumes = volumesList.stream().mapToLong(Integer::longValue).toArray();

        double volatilityScore = calculateVolatility(closePrices);
        double priceTrendScore = calculatePriceTrend(closePrices);
        double volumeScore = calculateVolumeScore(volumes);

        System.out.println("Raw Volatility Score: " + volatilityScore);
        System.out.println("Raw Price Trend Score: " + priceTrendScore);
        System.out.println("Raw Volume Score: " + volumeScore);

        // Normalize the scores using actual historical min/max values
        double normalizedVolatility = normalizeScore(volatilityScore, 0, 100);
        double normalizedPriceTrend = normalizeScore(priceTrendScore, -1, 1);
        double normalizedVolume = normalizeScore(volumeScore, 0,    Integer.MAX_VALUE);

        System.out.println("Normalized Volatility Score: " + normalizedVolatility);
        System.out.println("Normalized Price Trend Score: " + normalizedPriceTrend);
        System.out.println("Normalized Volume Score: " + normalizedVolume);

        // Calculate the weighted average
        double riskScore = normalizedVolatility * 0.3 +
                normalizedPriceTrend * 0.5 +
                normalizedVolume * 0.2;

        riskScore = Math.min(riskScore, 100);
        System.out.println("Normalized Risk Score: " + riskScore);
        return just(riskScore);
    }

    private static double normalizeScore(double value, double min, double max) {
        // If the value is already above the max, it will result in a value greater than 1 after normalization,
        // which when multiplied by 100, can give a value greater than 100.
        // It's important to make sure that value is between min and max.
        if (value < min) return 0;   // Value is below the minimum range, set it to 0.
        if (value > max) return 100; // Value is above the maximum range, set it to 100.

        return (value - min) / (max - min) * 100;
    }

    // Calculate standard deviation of returns as volatility
    private static double calculateVolatility(double[] prices) {
        double mean = Arrays.stream(prices).average().orElse(Double.NaN);
        double variance = Arrays.stream(prices)
                .map(price -> price - mean)
                .map(delta -> delta * delta)
                .average().orElse(Double.NaN);
        return Math.sqrt(variance);
    }

    // Calculate the price trend based on the last closing price against the SMA
    private static double calculatePriceTrend(double[] prices) {
        double sma = Arrays.stream(prices).average().orElse(Double.NaN);
        double lastPrice = prices[prices.length - 1];
        return (lastPrice - sma) / sma;
    }

    // Calculate the Exponential Moving Average (EMA) for volume
    private static double calculateVolumeScore(long[] volumes) {
        double alpha = 2.0 / (volumes.length + 1); // Smoothing factor
        double ema = volumes[0]; // Start with the first volume value

        for (int i = 1; i < volumes.length; i++) {
            ema = alpha * volumes[i] + (1 - alpha) * ema;
        }

        return ema;
    }
}
