package com.aluracursos.conversormoneda.models;

import java.time.LocalDateTime;

public class CurrencyConversion {
    private String fromCountry;
    private String toCountry;
    private Double amount;
    private Double amountConverted;
    private LocalDateTime createdAt;

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "CurrencyConversion{" +
                "fromCountry='" + fromCountry + '\'' +
                ", toCountry='" + toCountry + '\'' +
                ", amount=" + amount +
                ", amountConverted=" + amountConverted +
                ", createdAt=" + createdAt +
                '}';
    }
}
