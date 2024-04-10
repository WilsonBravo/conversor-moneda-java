package com.aluracursos.conversormoneda.models;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.Map;

public class CountryInfo {
    private Name name;
    private Flags flags;
    private Map<String, Currency> currencies;
    private List<String> capital;
    private int population;
    private List<String> timezones;

    private static class Name {
        String common;
        String official;
        private Map<String, NativeName> nativeName;

        private static class NativeName {
            String official;
            String common;

            @Override
            public String toString() {
                return "NativeName{" +
                        "official='" + official + '\'' +
                        ", common='" + common + '\'' +
                        '}';
            }
        }
    }
    private static class Flags {
        String png;
        String svg;
        String alt;
    }
    private static class Currency {
        private String name;
        private String symbol;

        @Override
        public String toString() {
            return "Currency{" +
                    "name='" + name + '\'' +
                    ", symbol='" + symbol + '\'' +
                    '}';
        }
    }

//    @Override
//    public String toString() {
//        return "CountryInfo{" +
//                "name=" + name.official +
//                ", native_name =" + name.nativeName +
//                ", flag='" + flags.alt + '\'' +
//                ", capital='" + capital + '\'' +
//                ", population=" + population +
//                ", timezones=" + timezones +
//                ", currencies=" + currencies +
//                '}';
//    }
    @Override
    public String toString() {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        return gson.toJson(this);
    }
}
