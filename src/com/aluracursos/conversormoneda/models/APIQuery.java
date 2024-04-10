package com.aluracursos.conversormoneda.models;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

import java.time.LocalDateTime;

public class APIQuery {
    // pair conversion
    public void getCurrencyConversion(CurrencyConversion converter) {
        URI url = URI.create("https://v6.exchangerate-api.com/v6/b8946c39b8e9f6436397ed67/pair/"
                +converter.getFromCountry()
                +"/"+converter.getToCountry()
                +"/"+converter.getAmount());

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();

        HttpResponse<String> response = null;

        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
        double conversionResult = jsonObject.get("conversion_result").getAsDouble();

        converter.setAmountConverted(conversionResult);
        converter.setCreatedAt(LocalDateTime.now().toString());

    }

    // list conversion rate
    public List<Map<String, Double>> getCurrencyList(String currency){
        URI url = URI.create("https://open.er-api.com/v6/latest/"+currency);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();

        HttpResponse<String> response = null;

        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
        JsonObject ratesObject = jsonObject.getAsJsonObject("rates");

        List<Map<String, Double>> currencyList = new ArrayList<>();

        Set<Map.Entry<String, JsonElement>> entries = ratesObject.entrySet();

        for (Map.Entry<String, com.google.gson.JsonElement> entry : entries) {
            String currencyCode = entry.getKey();
            double conversionRate = entry.getValue().getAsDouble();

            Map<String, Double> currencyMap = new HashMap<>();
            currencyMap.put(currencyCode, conversionRate);

            currencyList.add(currencyMap);
        }

        return currencyList;
    }

    // country info using currency
    public CountryInfo getCountryInfo(String currency){
        URI url = URI.create("https://restcountries.com/v3.1/currency/"+currency+"?fields=name,capital,currencies,population,flags,timezones");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();

        HttpResponse<String> response = null;

        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return new Gson().fromJson(response.body(), CountryInfo[].class)[0];
    }
}
