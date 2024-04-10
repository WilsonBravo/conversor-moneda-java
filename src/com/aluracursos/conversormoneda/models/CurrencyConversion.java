package com.aluracursos.conversormoneda.models;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class CurrencyConversion {
    private String fromCountry;
    private String toCountry;
    private Double amount;
    private Double amountConverted;
    private String createdAt;

    public String getFromCountry() {
        return fromCountry;
    }

    public void setFromCountry(String fromCountry) {
        this.fromCountry = fromCountry;
    }

    public String getToCountry() {
        return toCountry;
    }

    public void setToCountry(String toCountry) {
        this.toCountry = toCountry;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getAmountConverted() {
        return amountConverted;
    }

    public void setAmountConverted(Double amountConverted) {
        this.amountConverted = amountConverted;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public CurrencyConversion setValues (CurrencyConversion converter) {
        this.createdAt = converter.getCreatedAt();
        this.amount = converter.getAmount();
        this.toCountry = converter.getToCountry();
        this.fromCountry = converter.getFromCountry();
        this.amountConverted = converter.getAmountConverted();

        return this;
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        return gson.toJson(this);
    }
}
