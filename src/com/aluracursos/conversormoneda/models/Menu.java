package com.aluracursos.conversormoneda.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    // Lists
    List<CurrencyConversion> conversionHistoric = new ArrayList<>();
    CurrencyList currencyList = new CurrencyList();


    // Objects
    CountryInfo country = new CountryInfo();
    CurrencyConversion converter = new CurrencyConversion();
    APIQuery apiQuery = new APIQuery();

    private String initialMenu = """
        ************************************************************
        Welcome to the currency converter!
        Please choose one of the following options:
        
            1- Convert an amount from one currency to another (e.g., 436000.0 COP to USD).
            2- View the ISO codes that can be converted (e.g., COP, USD, JPY).
            3- View the current exchange rate of a currency (e.g., COP).
            4- View country information based on the ISO code of its currency (e.g., COP -> Colombia).
            5- View your conversion history.
            
        To exit the program, please enter 'exit'.
        ************************************************************
        """;


    private String menuInicial = """
        ************************************************************
        Bienvenido/a al conversor de divisa!
        Escoja una de las opciones:
        
            1- Convertir cantidad de una divisa a otra (Ej: 436000.0 COP a USD).
            2- Ver los códigos ISO que se pueden convertir (Ej: COP, USD, JPY).
            3- Ver la taza de cambio actual de una moneda (Ej: COP).
            4- Ver información del país a partir del código ISO de su moneda (Ej: COP -> Colombia).
            5- Ver tu historial de conversiones.
            
        Para finalizar el programa, por favor ingrese 'salir'.
        ************************************************************
        """;

    public void setChoice (String option, Scanner input) {

        String currencyNameFrom;
        String currencyNameTo;
        String currencyName;
        String amount;

        try {
            // Switch Case
            switch (option) {
                // Change currency
                case "1":

                    System.out.println("Ingresa el código ISO de la moneda de origen (Ej: COP).");
                    currencyNameFrom = input.next();
                    System.out.println("Ingresa el código ISO de la moneda de destino (Ej: USD).");
                    currencyNameTo = input.next();
                    System.out.println("Ingresa la cantidad para el cambio de divisa (Ej. 436000.0)");
                    amount = input.next();

                    converter.setFromCountry(currencyNameFrom);
                    converter.setToCountry(currencyNameTo);
                    converter.setAmount(Double.parseDouble(amount));

                    apiQuery.getCurrencyConversion(converter);

                    conversionHistoric.add(converter);

                    System.out.println("Cantidad convertida: "+converter.getAmountConverted()+" "+currencyNameTo);
                    System.out.println("\nPara ver el historial de conversiones puede ingresar la opción 5.");
                    System.out.println("Ingrese una nueva opción, o ingrese 'salir' para finalizar el programa.");

                    break;
                //
                case "2":

                    System.out.println(currencyList.getCurrencyNames());
                    System.out.println("\nPara más información sobre el país de origen de cualquier moneda puede ingresar la opción 4.");
                    System.out.println("Ingrese una nueva opción, o ingrese 'salir' para finalizar el programa.");

                    break;
                case "3":

                    System.out.println("Ingresa el código ISO de la moneda (Ej: COP).");
                    currencyName = input.next();

                    currencyList.setCurrencyList(apiQuery.getCurrencyList(currencyName));
                    System.out.println(currencyList);

                    System.out.println("\nPara realizar una conversión entre diferentes monedas puede ingresar la opción 1.");
                    System.out.println("Ingrese una nueva opción, o ingrese 'salir' para finalizar el programa.");

                    break;
                case "4":

                    System.out.println("Ingresa el código ISO de la moneda (Ej: COP).");
                    currencyName = input.next();

                    country = apiQuery.getCountryInfo(currencyName);
                    System.out.println(country);

                    System.out.println("\nIngrese una nueva opción, o ingrese 'salir' para finalizar el programa.");

                    break;
                case "5":

                    if (!conversionHistoric.isEmpty()) {
                        System.out.println(conversionHistoric);
                        System.out.println("\nIngrese una nueva opción, o ingrese 'salir' para finalizar el programa.");
                    } else {
                        System.out.println("No hay historial.");
                    }

                    break;
                default:

                    System.out.println("Ingrese una opción válida.");
                    break;

            }

        } catch (Exception e) {
            System.out.println("Nombre del error: " + e.getClass().getSimpleName());
            System.out.println("Mensaje del error: " + e.getMessage());

            System.out.println("\nIngrese una nueva opción, o ingrese 'salir' para finalizar el programa.");
        }

    }

    public String getInitialMenu() {
        return initialMenu;
    }

    public String getMenuInicial() {
        return menuInicial;
    }
}
