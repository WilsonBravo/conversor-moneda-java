package com.aluracursos.conversormoneda.models;

import java.util.List;
import java.util.Map;

public class CurrencyList {
    List<Map<String, Double>> currencyList;

    public List<Map<String, Double>> getCurrencyList() {
        return currencyList;
    }

    public void setCurrencyList(List<Map<String, Double>> currencyList) {
        this.currencyList = currencyList;
    }

    public String getCurrencyNames(){
        String message="    ";
        int countPrint=0;

        for (Map<String, Double> currencyMap : currencyList) {
            if (countPrint>9){
                countPrint=0;
                message+="\n    ";
            }
            for (Map.Entry<String, Double> entry : currencyMap.entrySet()) {
                message+="  ";
                message+=entry.getKey();
            }
            countPrint++;
        }
        return message;
    }

    @Override
    public String toString() {
        String message="    ";
        int countPrint=0;

        for (Map<String, Double> currencyMap : currencyList) {
            if (countPrint>5){
                countPrint=0;
                message+="\n    ";
            }
            for (Map.Entry<String, Double> entry : currencyMap.entrySet()) {
                message+="  ";
                message+=entry.getKey() + ": " + String.format("%f", entry.getValue());
            }
            countPrint++;
        }
        return message;
    }
}
